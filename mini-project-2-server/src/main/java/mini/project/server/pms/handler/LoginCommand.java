package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mini.project.server.pms.domain.Login;
import mini.project.server.util.Prompt;

public class LoginCommand implements Command {

  Login login;

  public LoginCommand (Login login) {
    this.login = login;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[로그인] ");
      login.setAdminPw(1111);
      login.setAdmin(Prompt.inputInt("관리자(0) or 일반회원(1) : ", out, in));

      if (login.getAdmin() == 0) {
        while(true) {
          if (login.getAdminPw() != Prompt.inputInt("비밀번호 : ", out, in)) {
            out.println("비밀번호가 틀렸습니다!");
            out.println(" ");
            out.flush();
          } else {
            break;
          }
        }
        out.println(" ");
        login.setName("bitcamp");
        out.printf("%s님 안녕하세요.\n", login.getName());
        out.println(" ");
        out.println();
        out.flush();
      } else {
        login.setName(Prompt.inputString("성함을 입력해주세요 : ", out, in));
        out.println(" ");
        out.printf("%s님 안녕하세요. '/test/start'로 B-BTI검사를 시작하세요.\n", login.getName());
        out.println(" ");
        out.println();
        out.flush();
      }


    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
