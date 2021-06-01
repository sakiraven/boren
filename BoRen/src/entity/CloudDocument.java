package entity;

import java.sql.Timestamp;

/**
 * CloudDocument entity. @author MyEclipse Persistence Tools
 */

public class CloudDocument implements java.io.Serializable {

	// Fields

	private Integer docId;
	private UserInfo userInfo;
	private String docName;
	private Timestamp docTime;

	// Constructors

	/** default constructor */
	public CloudDocument() {
	}

	/** full constructor */
	public CloudDocument(UserInfo userInfo, String docName, Timestamp docTime) {
		this.userInfo = userInfo;
		this.docName = docName;
		this.docTime = docTime;
	}

	// Property accessors

	public Integer getDocId() {
		return this.docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Timestamp getDocTime() {
		return this.docTime;
	}

	public void setDocTime(Timestamp docTime) {
		this.docTime = docTime;
	}

}