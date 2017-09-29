package com.allen.base.scheduled;

import com.allen.service.teachplan.teachplan.CloseTeachPlanSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Allen on 2017/9/29.
 */
@Component
public class CheckTeachPlanStateScheduled {

    @Autowired
    private CloseTeachPlanSerivce closeTeachPlanSerivce;

    @Scheduled(cron = "0 55 10 * * ?")
    public void check() throws Exception{
        closeTeachPlanSerivce.colseAll();
    }
}
