package com.hengtaierp.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName system_user
 */
@TableName(value = "system_user")
@Data
public class SystemUser implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 0)
    private String username;

    /**
     * 账号
     */
    @ExcelProperty(value = "账号", index = 1)
    private String account;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码", index = 2)
    private String password;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别", index = 3)
    private Object gender;

    /**
     * 学历
     */
    @ExcelProperty(value = "学历", index = 4)
    private String education;

    /**
     * 家庭住址
     */
    @ExcelProperty(value = "家庭住址", index = 5)
    private String homeAddress;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱", index =6)
    private String email;

    /**
     * 身份证
     */
    @ExcelProperty(value = "身份证", index = 7)
    private String identity;

    /**
     * 出生年月日
     */
    @ExcelProperty(value = "出生年月日", index = 5)
    private String dateOfBirth;

    /**
     * 创建时间
     */

    private Date creationTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SystemUser other = (SystemUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
                && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
                && (this.getHomeAddress() == null ? other.getHomeAddress() == null : this.getHomeAddress().equals(other.getHomeAddress()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
                && (this.getDateOfBirth() == null ? other.getDateOfBirth() == null : this.getDateOfBirth().equals(other.getDateOfBirth()))
                && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getHomeAddress() == null) ? 0 : getHomeAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getDateOfBirth() == null) ? 0 : getDateOfBirth().hashCode());
        result = prime * result + ((getCreationTime() == null) ? 0 : getCreationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", education=").append(education);
        sb.append(", homeAddress=").append(homeAddress);
        sb.append(", eMail=").append(email);
        sb.append(", identity=").append(identity);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}