package com.allen.entity.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 主观题答案
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "subjective_item_answer")
public class SubjectiveItemAnswer {

    @Id
    @GeneratedValue
    private long id;                            //id
    private long subjectiveItemId;              //题目id
    private String answer;                      //答题要点
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getSubjectiveItemId() {
        return subjectiveItemId;
    }

    public void setSubjectiveItemId(long subjectiveItemId) {
        this.subjectiveItemId = subjectiveItemId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
