import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: springboot-scheduled
 * @description: 创建线程的三种方式测试
 * @author: sjk
 * @create: 2018-08-03 11:24
 **/
public class NewThread3Test {

    private Log log = LogFactory.getLog(NewThread2Test.class);

    @Test
    public void test1() {

        FutureTask<Integer> ft = new FutureTask<>(new MyCallable());
        new Thread(ft).start();
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        Integer sum = null;
        try {
            sum = ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("sum="+sum);
    }

    public class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum =0;

            for (int i = 0; i < 100; i++) {
                log.info(Thread.currentThread().getName()+"////////////////////////////"+i);
                sum += i;
            }

            return sum;
        }
    }

    @Test
    public void test2() {

        FutureTask<Integer> ft1 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum =0;
                for (int i = 0; i < 100; i++) {
                    log.info(Thread.currentThread().getName()+"////////////////////////////"+i);
                    sum += i;
                }
                return sum;
            }
        });
        FutureTask<Integer> ft2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum =0;
                for (int i = 0; i < 100; i++) {
                    log.info(Thread.currentThread().getName()+"////////////////////////////"+i);
                    sum += i;
                }
                return sum;
            }
        });
        FutureTask<Integer> ft3 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum =0;
                for (int i = 0; i < 100; i++) {
                    log.info(Thread.currentThread().getName()+"////////////////////////////"+i);
                    sum += i;
                    if(i==99){
                        Thread.sleep(1000*5);
                    }
                }
                return sum;
            }
        });




        new Thread(ft1).start();
        new Thread(ft2).start();
        new Thread(ft3).start();
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
        Integer sum1 = null;
        Integer sum2 = null;
        Integer sum3 = null;
        try {
            sum1 = ft1.get();
            System.out.println("sum1="+sum1);
            sum2 = ft2.get();
            System.out.println("sum2="+sum2);
            sum3 = ft3.get();
            System.out.println("sum3="+sum3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
