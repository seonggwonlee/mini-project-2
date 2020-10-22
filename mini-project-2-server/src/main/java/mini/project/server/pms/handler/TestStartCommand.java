package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Test;
import mini.project.server.pms.domain.Type;
import mini.project.server.util.Prompt;

public class TestStartCommand implements Command {

  List<Test> testList;
  List<Type> typeList;

  public TestStartCommand (List<Test> list, List<Type> typeList) {
    this.testList = list;
    this.typeList = typeList;

  }
//  int[] answers = new int[5];

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      Test test = new Test();

      int count = 0;
      out.println("[테스트 시작]");
      out.println("1. 다른 사람들에게 자신을 소개하는 것을 어려워 합니다.");
      test.setFirstAnswer((Prompt.inputInt(
          "매우 그렇다(1), 그렇다(2), 보통이다(3), 아니다(4), 매우 아니다(5)", out, in)));

      out.println("종종 주변을 무시하거나 잊어버리는 생각에 빠지곤 합니다.");
      test.setSecondAnswer((Prompt.inputInt(
          "매우 그렇다(1), 그렇다(2), 보통이다(3), 아니다(4), 매우 아니다(5)", out, in)));

      out.println("이메일에 가능한 빨리 회신하려고 하고 지저분한 편지함을 참을 수 없습니다.");
      test.setThirdAnswer((Prompt.inputInt(
          "매우 그렇다(1), 그렇다(2), 보통이다(3), 아니다(4), 매우 아니다(5)", out, in)));

      out.println("중암갑을 받을 때에도 쉽게 침착하게 집중력을 유지할 수 있습니다.");
      test.setFourthAnswer((Prompt.inputInt(
          "매우 그렇다(1), 그렇다(2), 보통이다(3), 아니다(4), 매우 아니다(5)", out, in)));

      out.println("보통 대화를 먼저 시작하지 않습니다.");
      test.setFifthAnswer((Prompt.inputInt(
          "매우 그렇다(1), 그렇다(2), 보통이다(3), 아니다(4), 매우 아니다(5)", out, in)));

      test.setCount(test.getFirstAnswer(), test.getSecondAnswer(), test.getThirdAnswer(),
          test.getFourthAnswer(), test.getFifthAnswer());

      out.println(test.getCount());


      //      testList.add(test);
      out.println("[테스트 결과]");
//      for (int i = 0; answers[i] < 5; i++) {
        if (test.getCount() == 5) {
        } else if (5 < test.getCount() && test.getCount() < 10) {
//          Type type = findByNo(1);
//          out.println(type.getName());
//          out.println(type.getIntroduction());
          out.println("ESTJ");
        } else if (10 < test.getCount() && test.getCount() < 15) {
          out.println("ESTJ");
        } else if (15 < test.getCount() && test.getCount() < 20) {
          out.println("ISTJ");
        } else if (20 < test.getCount() && test.getCount() <= 25) {
          out.println("INFP");
        } else {
        }
//        switch(answers[i]) {
//          case 1 :
//            break;
//          case 2 :
//            break;
//          case 3 :
//            break;
//          case 4 :
//            break;
//          case 5 :
//            break;
//        }
//      }
        testList.add(test);
        out.println("테스트 결과를 저장하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
  private Type findByNo(int no) {
    for (int i = 0; i < typeList.size(); i++) {
      Type type = typeList.get(i);
      if (type.getNo() == no) {
        return type;
      }
    }
    return null;
  }
}
