package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.server.pms.domain.Type;
import mini.project.server.util.Prompt;

public class TypeAddCommand implements Command {

  List<Type> typeList;

  public TypeAddCommand(List<Type> list) {
    this.typeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[회원 등록]");

      Type type = new Type();
      type.setNo(Prompt.inputInt("번호? ", out, in));
      type.setName(Prompt.inputString("이름? ", out, in));
      type.setRomance(Prompt.inputString("연애? ", out, in));
      type.setFriendship(Prompt.inputString("우정? ", out, in));
      type.setStrength(Prompt.inputString("장점? ", out, in));
      type.setWeakness(Prompt.inputString("약점? ", out, in));

      typeList.add(type);

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
