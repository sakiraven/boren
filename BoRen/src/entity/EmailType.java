package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * EmailType entity. @author MyEclipse Persistence Tools
 */

public class EmailType implements java.io.Serializable {

	// Fields

	private Integer emailTypeId;
	private String emailType;
	private Set gmEmails = new HashSet(0);

	// Constructors

	/** default constructor */
	public EmailType() {
	}

	/** full constructor */
	public EmailType(String emailType, Set gmEmails) {
		this.emailType = emailType;
		this.gmEmails = gmEmails;
	}

	// Property accessors

	public Integer getEmailTypeId() {
		return this.emailTypeId;
	}

	public void setEmailTypeId(Integer emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public Set getGmEmails() {
		return this.gmEmails;
	}

	public void setGmEmails(Set gmEmails) {
		this.gmEmails = gmEmails;
	}

}