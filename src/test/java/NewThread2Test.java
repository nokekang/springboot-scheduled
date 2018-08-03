import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @program: springboot-scheduled
 * @description: 创建线程的三种方式测试
 * @author: sjk
 * @create: 2018-08-03 11:24
 **/
public class NewThread2Test {

    private Log log = LogFactory.getLog(NewThread2Test.class);

    @Test
    public void test1(){
        new Thread(new MyRunnable1()).start();
        new Thread(new MyRunnable2()).start();
        new Thread(new MyRunnable3()).start();
        while (true){

        }
    }

    public class MyRunnable1 implements Runnable{

        @Override
        public void run() {

            for (int i = 100; i < 200; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }

    public class MyRunnable2 implements Runnable{

        @Override
        public void run() {

            for (int  i = 100; i < 200; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }

    public class MyRunnable3 implements Runnable{

        @Override
        public void run() {

            for (int  i = 100; i < 200; i++) {
                log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
            }
        }

    }


    @Test
    public void test2(){
        new Thread(new Runnable() {
           @Override
           public void run() {

               for (int  i = 100; i < 200; i++) {
                   log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
               }

           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int  i = 100; i < 200; i++) {
                    log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {


                for (int  i = 100; i < 200; i++) {
                    log.info( Thread.currentThread().getName()+"//////////////////////////////////"+i);
                }

            }
        }).start();

        while (true){

        }
    }






}
