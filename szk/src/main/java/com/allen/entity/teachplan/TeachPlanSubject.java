package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 教学计划的专题
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "teach_plan_subject")
public class TeachPlanSubject {

    public static final int STATE_OPEN = 0;     //正常
    public static final int STATE_CLOSE = 1;    //关闭

    public static final int OBJECTIVESTATE_NOT = 0; //未设置
    public static final int OBJECTIVESTATE_YES = 1; //已设置

    public static final int RESOURCESTATE_NOT = 0; //未设置
    public static final int RESOURCESTATE_YES = 1; //已设置

    public static final int SUBJECTIVESTATE_NOT = 0; //未设置
    public static final int SUBJECTIVESTATE_YES = 1; //已设置

    @Id
    @GeneratedValue
    private long id;
    private long teachPlanId;                   //教学计划id
    private String name;                        //专题名称
    private int state;                          //状态[0：正常；1：关闭]
    private int objectiveState;                 //前测状态[0：未设置；1：已设置]
    private Date objectiveBeginTime;            //前测开始时间
    private Date objectiveEndTime;              //前测结束时间
    private int resourceState;                  //课堂讨论状态[0：未设置；1：已设置]
    private Date resourceBeginTime;             //课堂讨论开始时间
    private Date resourceEndTime;               //课堂讨论结束时间
    private int subjectiveState;                //后测状态[0：未设置；1：已设置]
    private Date subjectiveBeginTime;           //后测开始时间
    private Date subjectiveEndTime;             //后测结束时间
    private String creator;                     //创建人
    private Date createTime = new Date();       //创建时间
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getObjectiveState() {
        return objectiveState;
    }

    public void setObjectiveState(int objectiveState) {
        this.objectiveState = objectiveState;
    }

    public int getResourceState() {
        return resourceState;
    }

    public void setResourceState(int resourceState) {
        this.resourceState = resourceState;
    }

    public int getSubjectiveState() {
        return subjectiveState;
    }

    public void setSubjectiveState(int subjectiveState) {
        this.subjectiveState = subjectiveState;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getObjectiveBeginTime() {
        return objectiveBeginTime;
    }

    public void setObjectiveBeginTime(Date objectiveBeginTime) {
        this.objectiveBeginTime = objectiveBeginTime;
    }

    public Date getObjectiveEndTime() {
        return objectiveEndTime;
    }

    public void setObjectiveEndTime(Date objectiveEndTime) {
        this.objectiveEndTime = objectiveEndTime;
    }

    public Date getResourceBeginTime() {
        return resourceBeginTime;
    }

    public void setResourceBeginTime(Date resourceBeginTime) {
        this.resourceBeginTime = resourceBeginTime;
    }

    public Date getResourceEndTime() {
        return resourceEndTime;
    }

    public void setResourceEndTime(Date resourceEndTime) {
        this.resourceEndTime = resourceEndTime;
    }

    public Date getSubjectiveBeginTime() {
        return subjectiveBeginTime;
    }

    public void setSubjectiveBeginTime(Date subjectiveBeginTime) {
        this.subjectiveBeginTime = subjectiveBeginTime;
    }

    public Date getSubjectiveEndTime() {
        return subjectiveEndTime;
    }

    public void setSubjectiveEndTime(Date subjectiveEndTime) {
        this.subjectiveEndTime = subjectiveEndTime;
    }
}
