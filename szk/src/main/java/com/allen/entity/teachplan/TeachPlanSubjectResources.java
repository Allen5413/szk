package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 教学计划的专题关联的资源
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "teach_plan_subject_resources")
public class TeachPlanSubjectResources {

    @Id
    @GeneratedValue
    private long id;
    private long teachPlanSubjectId;
    private long resourcesId;
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeachPlanSubjectId() {
        return teachPlanSubjectId;
    }

    public void setTeachPlanSubjectId(long teachPlanSubjectId) {
        this.teachPlanSubjectId = teachPlanSubjectId;
    }

    public long getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(long resourcesId) {
        this.resourcesId = resourcesId;
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
