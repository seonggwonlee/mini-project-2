package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Login;
import mini.project.server.util.Prompt;

public class LoginHandler implements Command {

  List<Login> LoginList;

  public LoginHandler (List<Login> list) {
    this.LoginList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("B-BTI 성격 유형");

      Login login = new Login();
      login.setName(Prompt.inputString("성함을 입력해주세요 : ", out, in));

      LoginList.add(login);

      out.println("성격유형 시작");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
