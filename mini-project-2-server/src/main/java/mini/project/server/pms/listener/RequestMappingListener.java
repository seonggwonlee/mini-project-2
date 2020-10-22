package mini.project.server.pms.listener;

import java.util.List;
import java.util.Map;
import mini.project.server.context.ApplicationContextListener;
import mini.project.server.pms.domain.Login;
import mini.project.server.pms.domain.Type;
import mini.project.server.pms.handler.LoginHandler;
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
    List<Login> LoginList = (List<Login>) context.get("LoginList");
    List<Type> typeList = (List<Type>) context.get("typeList");
    //    List<Project> projectList = (List<Project>) context.get("projectList");
    //    List<Task> taskList = (List<Task>) context.get("taskList");

    context.put("/login/start", new LoginHandler(LoginList));
    context.put("/test/start", new TestStartCommand());
    //    context.put("/board/list", new BoardListCommand(boardList));
    //    context.put("/board/detail", new BoardDetailCommand(boardList));
    //    context.put("/board/update", new BoardUpdateCommand(boardList));
    //    context.put("/board/delete", new BoardDeleteCommand(boardList));

    TypeListCommand typeListCommand = new TypeListCommand(typeList);
    context.put("/type/add", new TypeAddCommand(typeList));
    context.put("/type/list", typeListCommand);
    context.put("/type/detail", new TypeDetailCommand(typeList));
    context.put("/type/update", new TypeUpdateCommand(typeList));
    context.put("/type/delete", new TypeDeleteCommand(typeList));
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
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
