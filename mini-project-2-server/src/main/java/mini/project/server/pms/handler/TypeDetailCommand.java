package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Type;
import mini.project.server.util.Prompt;

public class TypeDetailCommand implements Command {

  List<Type> typeList;

  public TypeDetailCommand(List<Type> list) {
    this.typeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[타입 상세보기]");
      int no = Prompt.inputInt("번호? ", out, in);
      Type type = findByNo(no);

      if (type == null) {
        out.println("해당 번호의 타입이 없습니다.");
        return;
      }

      out.printf("이름: %s\n", type.getName());
      out.printf("소개: %s\n", type.getIntroduction());
      out.printf("장점: %s\n", type.getStrength());
      out.printf("약점: %s\n", type.getWeakness());
      out.printf("연애: %s\n", type.getRomance());
      out.printf("우정: %s\n", type.getFriendship());

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
