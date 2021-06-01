package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer cmmtId;
	private UserInfo userInfo;
	private Post post;
	private Integer cmmtFloor;
	private Timestamp cmmtTime;
	private Integer cmmtStatus;
	private String cmmtText;
	private Set messages = new HashSet(0);
	private Set commentTwoLevels = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(UserInfo userInfo, Post post, Integer cmmtFloor,
			Timestamp cmmtTime, Integer cmmtStatus, String cmmtText,
			Set messages, Set commentTwoLevels) {
		this.userInfo = userInfo;
		this.post = post;
		this.cmmtFloor = cmmtFloor;
		this.cmmtTime = cmmtTime;
		this.cmmtStatus = cmmtStatus;
		this.cmmtText = cmmtText;
		this.messages = messages;
		this.commentTwoLevels = commentTwoLevels;
	}

	// Property accessors

	public Integer getCmmtId() {
		return this.cmmtId;
	}

	public void setCmmtId(Integer cmmtId) {
		this.cmmtId = cmmtId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
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

	public Integer getCmmtStatus() {
		return this.cmmtStatus;
	}

	public void setCmmtStatus(Integer cmmtStatus) {
		this.cmmtStatus = cmmtStatus;
	}

	public String getCmmtText() {
		return this.cmmtText;
	}

	public void setCmmtText(String cmmtText) {
		this.cmmtText = cmmtText;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getCommentTwoLevels() {
		return this.commentTwoLevels;
	}

	public void setCommentTwoLevels(Set commentTwoLevels) {
		this.commentTwoLevels = commentTwoLevels;
	}

}