package entity;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer msgId;
	private Post post;
	private UserInfo userInfoByMsgSendToId;
	private UserInfo userInfoByMsgSendId;
	private Comment comment;
	private Integer msgType;
	private Integer msgStatus;
	private Timestamp msgTime;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Post post, UserInfo userInfoByMsgSendToId,
			UserInfo userInfoByMsgSendId, Comment comment, Integer msgType,
			Integer msgStatus, Timestamp msgTime) {
		this.post = post;
		this.userInfoByMsgSendToId = userInfoByMsgSendToId;
		this.userInfoByMsgSendId = userInfoByMsgSendId;
		this.comment = comment;
		this.msgType = msgType;
		this.msgStatus = msgStatus;
		this.msgTime = msgTime;
	}

	// Property accessors

	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserInfo getUserInfoByMsgSendToId() {
		return this.userInfoByMsgSendToId;
	}

	public void setUserInfoByMsgSendToId(UserInfo userInfoByMsgSendToId) {
		this.userInfoByMsgSendToId = userInfoByMsgSendToId;
	}

	public UserInfo getUserInfoByMsgSendId() {
		return this.userInfoByMsgSendId;
	}

	public void setUserInfoByMsgSendId(UserInfo userInfoByMsgSendId) {
		this.userInfoByMsgSendId = userInfoByMsgSendId;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Integer getMsgType() {
		return this.msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	public Timestamp getMsgTime() {
		return this.msgTime;
	}

	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}

}