package entity;

import java.sql.Timestamp;

/**
 * Ip entity. @author MyEclipse Persistence Tools
 */

public class Ip implements java.io.Serializable {

	// Fields

	private Integer ipId;
	private Account account;
	private String ipAddr;
	private Timestamp ipTime;

	// Constructors

	/** default constructor */
	public Ip() {
	}

	/** full constructor */
	public Ip(Account account, String ipAddr, Timestamp ipTime) {
		this.account = account;
		this.ipAddr = ipAddr;
		this.ipTime = ipTime;
	}

	// Property accessors

	public Integer getIpId() {
		return this.ipId;
	}

	public void setIpId(Integer ipId) {
		this.ipId = ipId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Timestamp getIpTime() {
		return this.ipTime;
	}

	public void setIpTime(Timestamp ipTime) {
		this.ipTime = ipTime;
	}

}