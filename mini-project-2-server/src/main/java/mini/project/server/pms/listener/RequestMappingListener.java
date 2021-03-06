package mini.project.server.pms.listener;

import java.util.List;
import java.util.Map;
import mini.project.server.context.ApplicationContextListener;
import mini.project.server.pms.domain.Login;
import mini.project.server.pms.domain.Member;
import mini.project.server.pms.domain.Test;
import mini.project.server.pms.domain.Type;
import mini.project.server.pms.handler.HelpCommand;
import mini.project.server.pms.handler.LoginCommand;
import mini.project.server.pms.handler.LogoutCommand;
import mini.project.server.pms.handler.MemberDeleteCommand;
import mini.project.server.pms.handler.MemberDetailCommand;
import mini.project.server.pms.handler.MemberListCommand;
import mini.project.server.pms.handler.MemberUpdateCommand;
import mini.project.server.pms.handler.SignUpCommand;
import mini.project.server.pms.handler.TestResultCommand;
import mini.project.server.pms.handler.TestStartCommand;
import mini.project.server.pms.handler.TypeAddCommand;
import mini.project.server.pms.handler.TypeDeleteCommand;
import mini.project.server.pms.handler.TypeDetailCommand;
import mini.project.server.pms.handler.TypeListCommand;
import mini.project.server.pms.handler.TypeUpdateCommand;

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.
    Login login = (Login) context.get("login");
    List<Type> typeList = (List<Type>) context.get("typeList");
    List<Test> testList = (List<Test>) context.get("testList");
    List<Member> memberList = (List<Member>) context.get("memberList");
    //    List<Task> taskList = (List<Task>) context.get("taskList");

    MemberListCommand memberListCommand = new MemberListCommand(memberList, login);
    context.put("/signUp", new SignUpCommand(memberList));
    context.put("/member/list", memberListCommand);
    context.put("/member/detail", new MemberDetailCommand(memberList, login));
    context.put("/member/update", new MemberUpdateCommand(memberList, login));
    context.put("/member/delete", new MemberDeleteCommand(memberList, login));

    context.put("/test/start", new TestStartCommand(testList,typeList,login));
    context.put("/test/result", new TestResultCommand(testList,typeList,login));
    //    context.put("/board/detail", new BoardDetailCommand(boardList));
    //    context.put("/board/update", new BoardUpdateCommand(boardList));
    //    context.put("/board/delete", new BoardDeleteCommand(boardList));
    context.put("/login", new LoginCommand(login, memberList));
    context.put("/logout", new LogoutCommand(login));
    //    context.put("/board/list", new BoardListCommand(boardList));
    //    context.put("/board/detail", new BoardDetailCommand(boardList));
    //    context.put("/board/update", new BoardUpdateCommand(boardList));
    //    context.put("/board/delete", new BoardDeleteCommand(boardList));

    TypeListCommand typeListCommand = new TypeListCommand(typeList, login);
    context.put("/type/add", new TypeAddCommand(typeList,login));
    context.put("/type/list", typeListCommand);
    context.put("/type/detail", new TypeDetailCommand(typeList, login));
    context.put("/type/update", new TypeUpdateCommand(typeList, login));
    context.put("/type/delete", new TypeDeleteCommand(typeList, login));
    //
    //    context.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
    //    context.put("/project/list", new ProjectListCommand(projectList));
    //    context.put("/project/detail", new ProjectDetailCommand(projectList));
    //    context.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
    //    context.put("/project/delete", new ProjectDeleteCommand(projectList));
    //
    //    context.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
    //    context.put("/task/list", new TaskListCommand(taskList));
    //    context.put("/task/detail", new TaskDetailCommand(taskList));
    //    context.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
    //    context.put("/task/delete", new TaskDeleteCommand(taskList));
    //
    //    context.put("/hello", new HelloCommand());
    //
    //    context.put("/calc", new CalculatorCommand());
    context.put("/help", new HelpCommand());
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
