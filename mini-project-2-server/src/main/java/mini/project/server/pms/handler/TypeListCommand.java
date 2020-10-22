package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import mini.project.server.pms.domain.Login;
import mini.project.server.pms.domain.Type;

public class TypeListCommand implements Command {

  List<Type> typeList;
  Login login;

  public TypeListCommand(List<Type> list, Login login) {
    this.typeList = list;
    this.login = login;

  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    if (login.getAdmin() != 0) {
      out.print("권한이 없습니다.");
      out.println();
      out.flush();
      return;
    }
    out.println("[타입 목록]");

    Iterator<Type> iterator = typeList.iterator();

    while (iterator.hasNext()) {
      Type type = iterator.next();
      out.printf("%d, %s, %s\n",
          type.getNo(),
          type.getName(),
          type.getIntroduction());
    }
  }

  public Type findByName(String name) {
    for (int i = 0; i < typeList.size(); i++) {
      Type type = typeList.get(i);
      if (type.getName().equals(name)) {
        return type;
      }
    }
    return null;
  }

}
