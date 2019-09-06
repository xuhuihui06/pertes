package com.kingduns.pertes.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.kingduns.pertes.config.bean.Constants;

public class User implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2342093553851724158L;

	private String id;

    private String accountNum;

    private String password;

    private String userName;

    private String phone;

    private String mail;

    private String workUnit;

    private Integer isMember;

    private Integer maxManageNum;

    private Integer delflg;

    private Date creTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum == null ? null : accountNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public Integer getMaxManageNum() {
        return maxManageNum;
    }

    public void setMaxManageNum(Integer maxManageNum) {
        this.maxManageNum = maxManageNum;
    }

    public Integer getDelflg() {
        return delflg;
    }

    public void setDelflg(Integer delflg) {
        this.delflg = delflg;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }
    
    public String getCredentialsSalt() {
		return this.accountNum + Constants.SALT;
	}
}