package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Login;
import mini.project.server.util.Prompt;

public class LoginStart implements Command {

  List<Login> LoginList;

  public LoginStart (List<Login> list) {
    this.LoginList = list;
  }
  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("B-BTI 성격 유형 ");

      Login login = new Login();
      login.setName(Prompt.inputString("성함을 입력해주세요 : ", out, in));

      LoginList.add(login);

      out.printf("%s님 안녕하세요. 성격 검사를 시작합니다.", login.getName());

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
