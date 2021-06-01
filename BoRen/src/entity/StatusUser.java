package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StatusUser entity. @author MyEclipse Persistence Tools
 */

public class StatusUser implements java.io.Serializable {

	// Fields

	private Integer statusId;
	private Timestamp statusTime;
	private Set userInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public StatusUser() {
	}

	/** full constructor */
	public StatusUser(Timestamp statusTime, Set userInfos) {
		this.statusTime = statusTime;
		this.userInfos = userInfos;
	}

	// Property accessors

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Timestamp getStatusTime() {
		return this.statusTime;
	}

	public void setStatusTime(Timestamp statusTime) {
		this.statusTime = statusTime;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

}