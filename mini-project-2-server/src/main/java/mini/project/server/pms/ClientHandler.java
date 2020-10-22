package mini.project.server.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// 클라이언트의 요청을 처리하는 일을 담당
public class ClientHandler implements Runnable {
  Socket socket;

  public ClientHandler (Socket socket) {
    this.socket = socket;
  }

  @Override
    public void run() {

    InetAddress address = this.socket.getInetAddress();
    System.out.printf("클라이언트와 연결됨(%s)\n", address.getHostAddress());

    try (Socket socket = this.socket; // try with resources 이용하여 자동 close()를 위해
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
      PrintWriter out = new PrintWriter(socket.getOutputStream());


      while (true) {
      String str = in.readLine();

      sendResponse(out, str);

      if (str.equalsIgnoreCase("quit"))
        break;
        }

      } catch (Exception e) {
        System.out.println("클라이언트와 통신 오류");
      }

    System.out.printf("클라이언트(%s)와 연결을 정상적으로 해제함\n", address.getHostAddress());
    }

  private void sendResponse (PrintWriter out, String message) {
    out.println(message);
    out.println();
    out.flush();
    } // 인스턴스 멤버 (필드 및 메서드)를 사용하지 않는 메서드는 static으로 선언하는 것이 원칙
      // 그러나 그것이 원칙이긴 하나, 정말 특별한 경우가 아니라면 확장성, 유연성 등을 위해 인스턴스
      // 메서드로 만드는 것이 좋다.
  }
