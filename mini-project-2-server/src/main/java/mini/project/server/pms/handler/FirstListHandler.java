package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Personalities;
import mini.project.server.util.Prompt;

public class FirstListHandler implements Command {

  List<Personalities> firstList;

  public FirstListHandler (List<Personalities> list) {
    this.firstList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("다른 사람들에게 자신을 소개하는 것을 어려워 합니다.");

      out.println("1) 매우 그렇다");
      out.println("2) 그렇다");
      out.println("3) 중간");
      out.println("4) 그렇지 않다");
      out.println("5) 매우 그렇지 않다");
      Personalities fList = new Personalities();
      fList.setFirstList(Prompt.inputInt("숫자를 입력해주세요 : ", out, in));

      firstList.add(fList);

      out.println("성격유형 시작");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
