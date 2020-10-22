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
