package com.allen.entity.resources;

import com.allen.util.StringUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * 教学资源表
 * Created by Allen on 2017/4/22 0022.
 */
@Entity
@Table(name = "teach_resources")
public class TeachResources {

    public static final int ISLINK_NOT = 0;
    public static final int ISLINK_YES = 1;

    @Id
    @GeneratedValue
    private long id;                            //id
    private String name;                        //题目
    private String content;                     //内容
    private String labelIds;                    //标签id组合
    private String labelNames;                  //标签名称组合
    private int isLink;                          //是否超链接
    private String remark;                      //备注
    private String creator;                     //创建人
    private Date createTime = new Date();       //创建时间
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间
    @Transient
    private String contentHtml;

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

    public String getContent() {return content;}

    public void setContent(String content) {
        this.content = content;
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

    public int getIsLink() {
        return isLink;
    }

    public void setIsLink(int isLink) {
        this.isLink = isLink;
    }

    public String getContentHtml() {
        return StringUtil.encodeHtml(this.getContent());
    }
}
