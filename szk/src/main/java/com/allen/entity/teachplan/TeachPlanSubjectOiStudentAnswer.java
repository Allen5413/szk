package com.allen.entity.teachplan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 学生客观题答题时，题目答案选项，以及正确答案和学生选择的答案
 * Created by Allen on 2017/4/23 0023.
 */
@Entity
@Table(name = "teach_plan_subject_oi_student_answer")
public class TeachPlanSubjectOiStudentAnswer {

    public static final int ISANSWER_NOT = 0;
    public static final int ISANSWER_YES = 1;

    public static final int ISSTUDENTCHANGE_NOT = 0;
    public static final int ISSTUDENTCHANGE_YES = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private long tpsoisId;                      //专题关联题目学生答题id
    private String answer;                      //答案
    private int isAnswer;                       //是否正确答案[0：错；1：对]
    private int isStudentChange;                //学生是否选择该答案[0：否；1：是]
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTpsoisId() {
        return tpsoisId;
    }

    public void setTpsoisId(long tpsoisId) {
        this.tpsoisId = tpsoisId;
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

    public int getIsStudentChange() {
        return isStudentChange;
    }

    public void setIsStudentChange(int isStudentChange) {
        this.isStudentChange = isStudentChange;
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
