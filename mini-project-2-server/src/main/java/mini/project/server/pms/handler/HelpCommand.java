package mini.project.server.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mini.project.server.util.Prompt;

public class HelpCommand implements Command {


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
    out.println(" ");
    out.println("[가이드 페이지]");
    out.println("/login => 로그인 페이지 진입");
    out.println("/test/start => 테스트 시작하기");
    out.println("/test/result => 자신의 테스트 결과만 조회 가능");
    out.println(" ");

    out.println("[관리자 가이드] ");
    out.println("/test/result => 전체 회원의 테스트 결과 조회 가능");
    out.println("/type/add => 성격유형 추가하기");
    out.println("/type/detail => 등록된 성격유형 상세정보 조회");
    out.println("/type/update => 등록된 성격유형 수정하기");
    out.println("/type/delete => 등록된 성격유형 삭제하기");
    out.println(" ");
    out.println("나가시려면 아무 키나 눌러주세요.");
    Prompt.inputString(" ", out, in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
