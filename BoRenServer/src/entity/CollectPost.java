package entity;

/**
 * CollectPost entity. @author MyEclipse Persistence Tools
 */

public class CollectPost implements java.io.Serializable {

	// Fields

	private Integer collPostId;
	private Integer postId;
	private Integer acctId;
	
	public Integer getCollPostId() {
		return collPostId;
	}
	public void setCollPostId(Integer collPostId) {
		this.collPostId = collPostId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	
}