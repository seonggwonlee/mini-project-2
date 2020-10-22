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
