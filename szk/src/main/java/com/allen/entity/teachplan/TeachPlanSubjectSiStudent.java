package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 学生主观题答题情况
 * Created by Allen on 2017/4/23 0023.
 */
@Entity
@Table(name = "teach_plan_subject_si_student")
public class TeachPlanSubjectSiStudent {


    @Id
    @GeneratedValue
    private long id;                            //id
    private long tpssiId;                       //专题关联题目id
    private long userId;                        //学生id
    private String answer;                      //学生提交的答案
    private long time;                          //答题耗时[存毫秒值]
    private String timeStr;                     //答题耗时[存分钟数]
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTpssiId() {
        return tpssiId;
    }

    public void setTpssiId(long tpssiId) {
        this.tpssiId = tpssiId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
