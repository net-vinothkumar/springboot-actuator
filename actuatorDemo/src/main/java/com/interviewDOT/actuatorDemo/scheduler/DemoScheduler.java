package com.interviewDOT.actuatorDemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {

    @Scheduled(fixedRate = 20000)
    public void scheduleTaskFixedRate() {
        System.out.println("I am inside the scheduler - fixed rate");
    }

    @Scheduled(fixedDelay = 20000)
    public void scheduleTaskFixedDelay() {
        System.out.println("I am inside the scheduler - fixed delay");
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void scheduleTaskCron() {
        System.out.println("I am inside the scheduler - fixed delay");
    }
}
