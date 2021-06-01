package entity;

/**
 * CollectPostType entity. @author MyEclipse Persistence Tools
 */

public class CollectPostType implements java.io.Serializable {

	// Fields

	private Integer collPostTypeId;
	private UserInfo userInfo;
	private PostType postType;

	// Constructors

	/** default constructor */
	public CollectPostType() {
	}

	/** full constructor */
	public CollectPostType(UserInfo userInfo, PostType postType) {
		this.userInfo = userInfo;
		this.postType = postType;
	}

	// Property accessors

	public Integer getCollPostTypeId() {
		return this.collPostTypeId;
	}

	public void setCollPostTypeId(Integer collPostTypeId) {
		this.collPostTypeId = collPostTypeId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public PostType getPostType() {
		return this.postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

}