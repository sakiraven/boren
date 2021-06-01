package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields
	private Integer acctId;
	private Integer userId;
	private String userName;
	private String userEmial;
	private Integer userPhone;
	private String userSex;
	private String userImg;
	private Integer userEx;
	private Integer userCoin;
	private Integer userBalance;
	private Integer userVip;
	private Timestamp userTime;
	private Integer userSignIn;
	private Integer userStatus;
	
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmial() {
		return userEmial;
	}
	public void setUserEmial(String userEmial) {
		this.userEmial = userEmial;
	}
	public Integer getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public Integer getUserEx() {
		return userEx;
	}
	public void setUserEx(Integer userEx) {
		this.userEx = userEx;
	}
	public Integer getUserCoin() {
		return userCoin;
	}
	public void setUserCoin(Integer userCoin) {
		this.userCoin = userCoin;
	}
	public Integer getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}
	public Integer getUserVip() {
		return userVip;
	}
	public void setUserVip(Integer userVip) {
		this.userVip = userVip;
	}
	public Timestamp getUserTime() {
		return userTime;
	}
	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
	}
	public Integer getUserSignIn() {
		return userSignIn;
	}
	public void setUserSignIn(Integer userSignIn) {
		this.userSignIn = userSignIn;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
}