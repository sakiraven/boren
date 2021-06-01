package entity;

import java.sql.Timestamp;

/**
 * Vip entity. @author MyEclipse Persistence Tools
 */

public class Vip implements java.io.Serializable {

	// Fields

	private Integer vipId;
	private UserInfo userInfo;
	private Timestamp vipTime;

	// Constructors

	/** default constructor */
	public Vip() {
	}

	/** full constructor */
	public Vip(UserInfo userInfo, Timestamp vipTime) {
		this.userInfo = userInfo;
		this.vipTime = vipTime;
	}

	// Property accessors

	public Integer getVipId() {
		return this.vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Timestamp getVipTime() {
		return this.vipTime;
	}

	public void setVipTime(Timestamp vipTime) {
		this.vipTime = vipTime;
	}

}