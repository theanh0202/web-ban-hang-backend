package com.vti.shopee.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TestScheduled {
    @Scheduled(cron = "0 0/1 * * * *")
    public void test(){
        System.out.println("job run at"+ Instant.now());
    }
}
