package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 学生客观题答题情况
 * Created by Allen on 2017/4/23 0023.
 */
@Entity
@Table(name = "teach_plan_subject_oi_student")
public class TeachPlanSubjectOiStudent {

    public static final int ISRIGHT_ERROR = 0;
    public static final int ISRIGHT_RIGHT = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private long tpsoiId;                       //专题关联题目id
    private long userId;                        //学生id
    private int isRight;                        //是否答对[0：错；1：对]
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

    public long getTpsoiId() {
        return tpsoiId;
    }

    public void setTpsoiId(long tpsoiId) {
        this.tpsoiId = tpsoiId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
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
}
