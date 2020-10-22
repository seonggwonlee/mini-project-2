package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface Command {
    // 클라이언트에게 응답할 때 사용할 출력 스트림을 파라미터로 받는다.
    // 클라이언트가 보낸 데이터를 읽을 때 사용할 입력 스트림을 파라미터로 받는다.
    void execute(PrintWriter out, BufferedReader in);
}
