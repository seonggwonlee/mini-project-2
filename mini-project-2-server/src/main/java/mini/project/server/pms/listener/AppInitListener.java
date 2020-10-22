<<<<<<< HEAD
package mini.project.server.pms.listener;

import java.util.Map;
import mini.project.server.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {
  @Override
  public void contextInitialized(Map<String,Object> context) {
    System.out.println("B-BTI 성격 유형 시작 페이지");
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    System.out.println("B-BTI 성격 유형을 종료합니다. ");
  }
}
=======
package mini.project.server.pms.listener;

import java.util.Map;
import mini.project.server.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {
  @Override
  public void contextInitialized(Map<String,Object> context) {
    System.out.println("MBTI 검사 실시");
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    System.out.println("MBTI 검사를 종료합니다.");
  }
}
>>>>>>> branch 'master' of https://github.com/cgkim449/mini-project-2.git
