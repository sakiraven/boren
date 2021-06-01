package entity;

/**
 * FansList entity. @author MyEclipse Persistence Tools
 */

public class FansList implements java.io.Serializable {

	// Fields

	private Integer fanId;
	private UserInfo userInfo;
	private Integer fanUser;
	private Integer fanFansUser;

	// Constructors

	/** default constructor */
	public FansList() {
	}

	/** minimal constructor */
	public FansList(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/** full constructor */
	public FansList(UserInfo userInfo, Integer fanUser, Integer fanFansUser) {
		this.userInfo = userInfo;
		this.fanUser = fanUser;
		this.fanFansUser = fanFansUser;
	}

	// Property accessors

	public Integer getFanId() {
		return this.fanId;
	}

	public void setFanId(Integer fanId) {
		this.fanId = fanId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getFanUser() {
		return this.fanUser;
	}

	public void setFanUser(Integer fanUser) {
		this.fanUser = fanUser;
	}

	public Integer getFanFansUser() {
		return this.fanFansUser;
	}

	public void setFanFansUser(Integer fanFansUser) {
		this.fanFansUser = fanFansUser;
	}

}