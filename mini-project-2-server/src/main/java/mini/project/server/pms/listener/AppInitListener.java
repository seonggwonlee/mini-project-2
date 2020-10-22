package mini.project.server.pms.listener;

import java.util.Map;
import mini.project.server.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {
  @Override
  public void contextInitialized(Map<String,Object> context) {
    System.out.println("B-BTI 관리 시스템");
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    System.out.println("B-BTI 관리 시스템을 종료합니다.");
  }
}
