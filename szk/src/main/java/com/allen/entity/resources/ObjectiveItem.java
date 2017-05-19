package com.allen.entity.resources;

import com.allen.util.StringUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 客观题
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "objective_item")
public class ObjectiveItem {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_MORE = 1;
    public static final int TYPE_NOT = 2;

    public static final int STATE_OPEN = 0;
    public static final int STATE_CLOSE = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private String name;                        //题目
    private int type;                           //类型[0：单选；1：多选；2：不定项]
    private int selectCount;                    //选项数
    private String reference;                   //参考资源
    private String labelIds;                    //标签id组合
    private String labelNames;                  //标签名称组合
    private Integer state;                      //状态[0：正常；1：关闭]
    private String remark;                      //备注
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(int selectCount) {
        this.selectCount = selectCount;
    }

    public String getReference() {
        return StringUtil.encodeHtml(reference);
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    public String getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
