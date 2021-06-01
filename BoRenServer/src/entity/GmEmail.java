package entity;

import java.sql.Timestamp;

/**
 * GmEmail entity. @author MyEclipse Persistence Tools
 */

public class GmEmail implements java.io.Serializable {

	// Fields

	private Integer emailId;
	private Integer emailType;
	private Integer sendId;
	private Integer sendToId;
	private String emailText;
	private Timestamp emailTime;
	private String emailQuote;
	private Integer emailStatus;
	public Integer getEmailId() {
		return emailId;
	}
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	public Integer getEmailType() {
		return emailType;
	}
	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getSendToId() {
		return sendToId;
	}
	public void setSendToId(Integer sendToId) {
		this.sendToId = sendToId;
	}
	public String getEmailText() {
		return emailText;
	}
	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}
	public Timestamp getEmailTime() {
		return emailTime;
	}
	public void setEmailTime(Timestamp emailTime) {
		this.emailTime = emailTime;
	}
	public String getEmailQuote() {
		return emailQuote;
	}
	public void setEmailQuote(String emailQuote) {
		this.emailQuote = emailQuote;
	}
	public Integer getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}
}