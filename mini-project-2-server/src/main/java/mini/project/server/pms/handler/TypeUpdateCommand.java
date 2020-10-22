package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Type;
import mini.project.server.util.Prompt;

public class TypeUpdateCommand implements Command {

  List<Type> typeList;

  public TypeUpdateCommand(List<Type> list) {
    this.typeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[타입 변경]");
      int no = Prompt.inputInt("번호? ", out, in);
      Type type = findByNo(no);

      if (type == null) {
        out.println("해당 번호의 타입이 없습니다.");
        return;
      }

      String name = Prompt.inputString(
          String.format("이름(%s)? ", type.getName()), out, in);
      String introduction = Prompt.inputString(
          String.format("소개(%s)? ", type.getIntroduction()), out, in);
      String strength = Prompt.inputString(
          String.format("장점(%s)? ", type.getStrength()), out, in);
      String weakness = Prompt.inputString(
          String.format("약점(%s)? ", type.getWeakness()), out, in);
      String romance = Prompt.inputString(
          String.format("연애(%s)? ", type.getRomance()), out, in);
      String friendship = Prompt.inputString(
          String.format("우정(%s)? ", type.getFriendship()), out, in);

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("타입 변경을 취소하였습니다.");
        return;
      }

      type.setName(name);
      type.setIntroduction(introduction);
      type.setStrength(strength);
      type.setWeakness(weakness);
      type.setRomance(romance);
      type.setFriendship(friendship);

      out.println("타입을 변경하였습니다.");

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
