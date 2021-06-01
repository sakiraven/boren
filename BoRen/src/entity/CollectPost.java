package entity;

/**
 * CollectPost entity. @author MyEclipse Persistence Tools
 */

public class CollectPost implements java.io.Serializable {

	// Fields

	private Integer collPostId;
	private Post post;
	private UserInfo userInfo;

	// Constructors

	/** default constructor */
	public CollectPost() {
	}

	/** full constructor */
	public CollectPost(Post post, UserInfo userInfo) {
		this.post = post;
		this.userInfo = userInfo;
	}

	// Property accessors

	public Integer getCollPostId() {
		return this.collPostId;
	}

	public void setCollPostId(Integer collPostId) {
		this.collPostId = collPostId;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}