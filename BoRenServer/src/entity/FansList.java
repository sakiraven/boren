package entity;

/**
 * FansList entity. @author MyEclipse Persistence Tools
 */

public class FansList implements java.io.Serializable {

	// Fields

	private Integer fanId;
	private Integer fanUser;
	private Integer fanFansUser;
	public Integer getFanId() {
		return fanId;
	}
	public void setFanId(Integer fanId) {
		this.fanId = fanId;
	}
	public Integer getFanUser() {
		return fanUser;
	}
	public void setFanUser(Integer fanUser) {
		this.fanUser = fanUser;
	}
	public Integer getFanFansUser() {
		return fanFansUser;
	}
	public void setFanFansUser(Integer fanFansUser) {
		this.fanFansUser = fanFansUser;
	}


}