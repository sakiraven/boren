package entity;

import java.sql.Timestamp;

/**
 * CommentTwoLevel entity. @author MyEclipse Persistence Tools
 */

public class CommentTwoLevel implements java.io.Serializable {

	// Fields

	private Integer cmmtTwoId;
	private UserInfo userInfoByCmmtSendToId;
	private UserInfo userInfoByCmmtSendId;
	private Comment comment;
	private String cmmtTwoText;
	private Integer cmmtFloor;
	private Timestamp cmmtTime;
	private Integer cmmtTwoStatus;

	// Constructors

	/** default constructor */
	public CommentTwoLevel() {
	}

	/** full constructor */
	public CommentTwoLevel(UserInfo userInfoByCmmtSendToId,
			UserInfo userInfoByCmmtSendId, Comment comment, String cmmtTwoText,
			Integer cmmtFloor, Timestamp cmmtTime, Integer cmmtTwoStatus) {
		this.userInfoByCmmtSendToId = userInfoByCmmtSendToId;
		this.userInfoByCmmtSendId = userInfoByCmmtSendId;
		this.comment = comment;
		this.cmmtTwoText = cmmtTwoText;
		this.cmmtFloor = cmmtFloor;
		this.cmmtTime = cmmtTime;
		this.cmmtTwoStatus = cmmtTwoStatus;
	}

	// Property accessors

	public Integer getCmmtTwoId() {
		return this.cmmtTwoId;
	}

	public void setCmmtTwoId(Integer cmmtTwoId) {
		this.cmmtTwoId = cmmtTwoId;
	}

	public UserInfo getUserInfoByCmmtSendToId() {
		return this.userInfoByCmmtSendToId;
	}

	public void setUserInfoByCmmtSendToId(UserInfo userInfoByCmmtSendToId) {
		this.userInfoByCmmtSendToId = userInfoByCmmtSendToId;
	}

	public UserInfo getUserInfoByCmmtSendId() {
		return this.userInfoByCmmtSendId;
	}

	public void setUserInfoByCmmtSendId(UserInfo userInfoByCmmtSendId) {
		this.userInfoByCmmtSendId = userInfoByCmmtSendId;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getCmmtTwoText() {
		return this.cmmtTwoText;
	}

	public void setCmmtTwoText(String cmmtTwoText) {
		this.cmmtTwoText = cmmtTwoText;
	}

	public Integer getCmmtFloor() {
		return this.cmmtFloor;
	}

	public void setCmmtFloor(Integer cmmtFloor) {
		this.cmmtFloor = cmmtFloor;
	}

	public Timestamp getCmmtTime() {
		return this.cmmtTime;
	}

	public void setCmmtTime(Timestamp cmmtTime) {
		this.cmmtTime = cmmtTime;
	}

	public Integer getCmmtTwoStatus() {
		return this.cmmtTwoStatus;
	}

	public void setCmmtTwoStatus(Integer cmmtTwoStatus) {
		this.cmmtTwoStatus = cmmtTwoStatus;
	}

}