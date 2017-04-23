package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 教学计划关联的学生
 * Created by Allen on 2017/4/21 0021.
 */
@Entity
@Table(name = "teach_plan_student")
public class TeachPlanStudent {
    @Id
    @GeneratedValue
    private long id;
    private long teachPlanId;
    private long userId;
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeachPlanId() {
        return teachPlanId;
    }

    public void setTeachPlanId(long teachPlanId) {
        this.teachPlanId = teachPlanId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
