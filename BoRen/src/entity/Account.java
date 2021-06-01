package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer acctId;
	private Admin admin;
	private String acctName;
	private String acctPwd;
	private Set userInfos = new HashSet(0);
	private Set ips = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(Admin admin, String acctName, String acctPwd, Set userInfos,
			Set ips) {
		this.admin = admin;
		this.acctName = acctName;
		this.acctPwd = acctPwd;
		this.userInfos = userInfos;
		this.ips = ips;
	}

	// Property accessors

	public Integer getAcctId() {
		return this.acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getAcctName() {
		return this.acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctPwd() {
		return this.acctPwd;
	}

	public void setAcctPwd(String acctPwd) {
		this.acctPwd = acctPwd;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

	public Set getIps() {
		return this.ips;
	}

	public void setIps(Set ips) {
		this.ips = ips;
	}

}