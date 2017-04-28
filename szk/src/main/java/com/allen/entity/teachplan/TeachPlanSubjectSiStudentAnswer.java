package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 学生主观题答题时，题目答案要点，以及是否答中要点
 * Created by Allen on 2017/4/23 0023.
 */
@Entity
@Table(name = "teach_plan_subject_si_student_answer")
public class TeachPlanSubjectSiStudentAnswer {

    public static final int ISANSWER_NOT = 0;
    public static final int ISANSWER_YES = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private long tpssisId;                      //专题关联题目学生答题id
    private String answer;                      //答案
    private int isAnswer;                       //是否答中要点[0：否；1：是]
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTpssisId() {
        return tpssisId;
    }

    public void setTpssisId(long tpssisId) {
        this.tpssisId = tpssisId;
    }

    public String getAnswer() {
        return answer;
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
