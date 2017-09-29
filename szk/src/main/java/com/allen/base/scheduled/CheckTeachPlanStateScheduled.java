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

    /**
     * 凌晨1点执行，检查教学计划，满足条件的就关闭
     * @throws Exception
     */
    @Scheduled(cron = "0 00 01 * * ?")
    public void check() throws Exception{
        closeTeachPlanSerivce.colseAll();
    }
}
