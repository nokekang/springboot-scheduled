package com.example.springbootscheduled.schedual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-scheduled
 * @description: 定时器类
 * @author: sjk
 * @create: 2018-08-02 14:40
 **/
@Component//加入spring的bean
public class SchedualedTask {

    private Log log = LogFactory.getLog(SchedualedTask.class);

//    @Scheduled(fixedRate = 1000*60*60)
    @Scheduled(fixedDelay = 1000*10)
    public void task1(){
        for (int i = 0; i < 100; i++) {
            log.info("task1================================================================="+i);
        }
    }

    @Scheduled(fixedDelay = 1000*10)
    public void task2(){
        for (int i = 0; i < 100; i++) {
            log.info("task2================================================================="+i);
        }
    }

}
