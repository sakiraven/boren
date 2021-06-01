package entity;


/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	private Integer acctId;
	private String acctName;
	private String acctPwd;
	private Integer acctAdmin;
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getAcctPwd() {
		return acctPwd;
	}
	public void setAcctPwd(String acctPwd) {
		this.acctPwd = acctPwd;
	}
	public Integer getAcctAdmin() {
		return acctAdmin;
	}
	public void setAcctAdmin(Integer acctAdmin) {
		this.acctAdmin = acctAdmin;
	}
}