package entity;

import java.sql.Timestamp;

/**
 * MessageWall entity. @author MyEclipse Persistence Tools
 */

public class MessageWall implements java.io.Serializable {

	// Fields

	private Integer wallId;
	private UserInfo userInfo;
	private String wallMessage;
	private Timestamp wallTime;

	// Constructors

	/** default constructor */
	public MessageWall() {
	}

	/** full constructor */
	public MessageWall(UserInfo userInfo, String wallMessage, Timestamp wallTime) {
		this.userInfo = userInfo;
		this.wallMessage = wallMessage;
		this.wallTime = wallTime;
	}

	// Property accessors

	public Integer getWallId() {
		return this.wallId;
	}

	public void setWallId(Integer wallId) {
		this.wallId = wallId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getWallMessage() {
		return this.wallMessage;
	}

	public void setWallMessage(String wallMessage) {
		this.wallMessage = wallMessage;
	}

	public Timestamp getWallTime() {
		return this.wallTime;
	}

	public void setWallTime(Timestamp wallTime) {
		this.wallTime = wallTime;
	}

}