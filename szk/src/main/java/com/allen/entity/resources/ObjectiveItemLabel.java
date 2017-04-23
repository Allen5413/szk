package com.allen.entity.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "objective_item_label")
public class ObjectiveItemLabel {
    @Id
    @GeneratedValue
    private long id;
    private long objectiveItemId;               //题目id
    private long labelId;                       //标签id
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

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
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
