package entity;

import java.sql.Timestamp;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields
	private Integer msgId;
	private Integer msgPostId;
	private Integer msgType;
	private Integer msgStatus;
	private Timestamp msgTime;
	private Integer msgSendId;
	private Integer msgSendToId;
	private Integer msgCommentId;
	private String postTitle;
	private Integer cmmtFloor;
	private String sendName;
	
	
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Integer getMsgPostId() {
		return msgPostId;
	}
	public void setMsgPostId(Integer msgPostId) {
		this.msgPostId = msgPostId;
	}
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	public Integer getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}
	public Timestamp getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Timestamp msgTime) {
		this.msgTime = msgTime;
	}
	public Integer getMsgSendId() {
		return msgSendId;
	}
	public void setMsgSendId(Integer msgSendId) {
		this.msgSendId = msgSendId;
	}
	public Integer getMsgSendToId() {
		return msgSendToId;
	}
	public void setMsgSendToId(Integer msgSendToId) {
		this.msgSendToId = msgSendToId;
	}
	public Integer getMsgCommentId() {
		return msgCommentId;
	}
	public void setMsgCommentId(Integer msgCommentId) {
		this.msgCommentId = msgCommentId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Integer getCmmtFloor() {
		return cmmtFloor;
	}
	public void setCmmtFloor(Integer cmmtFloor) {
		this.cmmtFloor = cmmtFloor;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	
	
	

}