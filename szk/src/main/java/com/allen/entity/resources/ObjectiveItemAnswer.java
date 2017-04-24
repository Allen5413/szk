package com.allen.entity.resources;

import com.allen.util.StringUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 客观题答案
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "objective_item_answer")
public class ObjectiveItemAnswer {

    public static final int ISANSWER_NOT = 0;
    public static final int ISANSWER_YES = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private long objectiveItemId;               //题目id
    private String answer;                      //选项
    private int isAnswer;                       //是否答案[0：否；1：是]
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getObjectiveItemId() {
        return objectiveItemId;
    }

    public void setObjectiveItemId(long objectiveItemId) {
        this.objectiveItemId = objectiveItemId;
    }

    public String getAnswer() {
        return StringUtil.encodeHtml(answer);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(int isAnswer) {
        this.isAnswer = isAnswer;
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
