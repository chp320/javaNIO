package org.example.ch2.ex2_7;

/**
 * 일반 쓰레드의 경우, "어플리케이션 내부의 모든 쓰레드가 종료되지 않으면 JVM 이 종료되지 않는"데
 * 데몬 쓰레드는 이러한 조건에서 예외가 된다. 즉, 데몬 쓰레드로 생성된 경우 어플리케이션이 종료되면 바로 종료한다.
 *
 * 일반 쓰레드 호출과 달리 start() 메서드 호출 전 setDaemon(true) 를 호출해서 '데몬 쓰레드' 설정을 해야한다.
 */
public class DaemonThreadTest {

    public static void main(String[] args) {
        // 쓰레드를 생성
        Thread t = new Thread() {
            public void run() {
                try {
                    // 5초간 정지
                    Thread.sleep(5000);
                    // 쓰레드 종료 메시지
                    System.out.println("MyThread 종료");
                } catch (Exception e) {
                    //
                }
            }
        };
//        // 데몬 쓰레드로 설정 (아래를 활성하지 않으면 일반 쓰레드와 동일하다.)
        t.setDaemon(true);
        // 쓰레드를 시작한다.
        t.start();

        // 만일 start() 이후 setDaemon() 호출하면 IllegalException 발생한다.
//        t.setDaemon(true);

        // main 메서드 종료 메시지
        System.out.println("main() 종료");
    }

}
