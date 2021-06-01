package entity;

import java.sql.Timestamp;

/**
 * GmEmail entity. @author MyEclipse Persistence Tools
 */

public class GmEmail implements java.io.Serializable {

	// Fields

	private Integer emailId;
	private EmailType emailType;
	private UserInfo userInfoByEmailSendId;
	private UserInfo userInfoByEmailSendToId;
	private String emailText;
	private Timestamp emailTime;
	private String emailQuote;
	private Integer emailStatus;
	private Integer emailType_1;

	// Constructors

	/** default constructor */
	public GmEmail() {
	}

	/** full constructor */
	public GmEmail(EmailType emailType, UserInfo userInfoByEmailSendId,
			UserInfo userInfoByEmailSendToId, String emailText,
			Timestamp emailTime, String emailQuote, Integer emailStatus,
			Integer emailType_1) {
		this.emailType = emailType;
		this.userInfoByEmailSendId = userInfoByEmailSendId;
		this.userInfoByEmailSendToId = userInfoByEmailSendToId;
		this.emailText = emailText;
		this.emailTime = emailTime;
		this.emailQuote = emailQuote;
		this.emailStatus = emailStatus;
		this.emailType_1 = emailType_1;
	}

	// Property accessors

	public Integer getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	public EmailType getEmailType() {
		return this.emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public UserInfo getUserInfoByEmailSendId() {
		return this.userInfoByEmailSendId;
	}

	public void setUserInfoByEmailSendId(UserInfo userInfoByEmailSendId) {
		this.userInfoByEmailSendId = userInfoByEmailSendId;
	}

	public UserInfo getUserInfoByEmailSendToId() {
		return this.userInfoByEmailSendToId;
	}

	public void setUserInfoByEmailSendToId(UserInfo userInfoByEmailSendToId) {
		this.userInfoByEmailSendToId = userInfoByEmailSendToId;
	}

	public String getEmailText() {
		return this.emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public Timestamp getEmailTime() {
		return this.emailTime;
	}

	public void setEmailTime(Timestamp emailTime) {
		this.emailTime = emailTime;
	}

	public String getEmailQuote() {
		return this.emailQuote;
	}

	public void setEmailQuote(String emailQuote) {
		this.emailQuote = emailQuote;
	}

	public Integer getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public Integer getEmailType_1() {
		return this.emailType_1;
	}

	public void setEmailType_1(Integer emailType_1) {
		this.emailType_1 = emailType_1;
	}

}