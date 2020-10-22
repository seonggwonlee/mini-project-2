package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mini.project.server.pms.domain.Login;
import mini.project.server.util.Prompt;

public class LogoutCommand implements Command {

  Login login;

  public LogoutCommand (Login login) {
    this.login = login;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      String input = Prompt.inputString("로그아웃하시겠습니까?(y/N) : ", out, in);
      if (input.equalsIgnoreCase("y")) {
        out.print("로그아웃되었습니다.");
        out.println();
        out.flush();
      }

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
