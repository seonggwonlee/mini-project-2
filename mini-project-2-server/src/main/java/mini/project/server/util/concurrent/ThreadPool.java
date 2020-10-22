package com.eomcs.util.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

  List<Worker> worker = new ArrayList<>();

  boolean stopping = false;

  class Worker extends Thread { // 스레드에게 작업을 맡기고, 깨우고, 완료하고, 다시 잠자기는 기능 부여
    Runnable task;

    public void setTask(Runnable task) {
      this.task = task; // 스레드가 할 작업 배정

      synchronized(this) {
        this.notify();
      }
    }

    @Override
      public void run() {

      synchronized(this) {

        while (true) {
          try {
            System.out.printf("[%s] - 스레드 대기 중\n", this.getName());

              this.wait();

              if(ThreadPool.this.stopping) {
                break;
              }

            System.out.printf("[%s] - 스레드 작업 시작\n", this.getName());
          } catch (Exception e) {
            System.out.printf("[%s] - 스레드 실행 중 예외 발생\n", this.getName());
              break;
          }
          try {
              task.run();
              System.out.printf("[%s] - 스레드 작업 종료\n", this.getName());
        } catch(Exception e) {
              System.out.printf("[%s] - %s\n", this.getName(), e.getMessage());
          break;
          } finally {
            worker.add(this);
            System.out.printf("[%s] - 스레드풀로 되돌아 감\n", this.getName());
          }
        }
      }
    }
  }


  public void execute(Runnable task) {

    if (stopping) {
      throw new RuntimeException("스레드 풀이 종료 상태입니다.");
    }
    Worker t;

    if (worker.size() == 0) {
      t = new Worker();
      System.out.printf("[%s] - 스레드 생성\n", t.getName());

      t.start();

      try {
        Thread.sleep(2000);
      } catch (Exception e) {

      }
    } else {
      t = worker.remove(0);
      System.out.printf("[%s] - 스레드를 꺼내 재사용\n", t.getName());
    }
  }
}
