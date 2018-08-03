import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @program: springboot-scheduled
 * @description: 创建线程的三种方式测试
 * @author: sjk
 * @create: 2018-08-03 11:24
 **/
public class NewThread1Test {

    private Log log = LogFactory.getLog(NewThread1Test.class);

    @Test
    public void test1(){
//        System.out.println("111111111111111111");
        new MyThread1().start();
        new MyThread2().start();
        new MyThread3().start();
        while (true){

        }
    }

    public class MyThread1 extends Thread{

        @Override
        public void run() {

            for (int i = 1; i < 101; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }

    public class MyThread2 extends Thread{

        @Override
        public void run() {

            for (int i = 1; i < 101; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }

    public class MyThread3 extends Thread{

        @Override
        public void run() {

            for (int i = 1; i < 101; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }


    @Test
    public void test2(){
//        System.out.println("111111111111111111");
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
                }
            }
        }.start();

        while (true){

        }
    }






}
