package com.allen.entity.user;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Allen on 2016/12/12.
 */
@Entity
@Table(name = "user")
public class User {
    public static final int STATE_DELETE = 0;     //删除
    public static final int STATE_ENABLE = 1;     //启用
    public static final int STATE_DISABLE = 2;    //停用

    public static final int TYPE_ADMIN = 0;     //管理员
    public static final int TYPE_STUDENT = 1;   //学生
    public static final int TYPE_TEACHER = 2;   //老师

    @Id
    @GeneratedValue
    private Long id;                            //主键
    private String zz;                          //zz
    private String studentCode;                 //学号
    private String name;                        //姓名
    private int type;                           //类型[0：管理员；1：学生；2：老师]
    private Integer state;                      //用户状态
    private String creator;                     //创建人
    private Date createTime = new Date();       //创建时间
    private String operator;                    //操作人
    private Date operateTime = new Date();      //操作时间
    @Version
    private Integer version;                    //版本号，用于乐观锁
    @Transient
    private String stateStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public String getStateStr() {
        switch (this.getState()){
            case 1:
                this.stateStr = "启用";
                break;
            case 2:
                this.stateStr = "停用";
                break;
            default:
                this.stateStr = "未知";
                break;
        }
        return stateStr;
    }
}
