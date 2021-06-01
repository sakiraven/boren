package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * PostType entity. @author MyEclipse Persistence Tools
 */

public class PostType implements java.io.Serializable {

	// Fields

	private Integer postTypeId;
	private String postType;
	private Integer postStatus;
	private Set posts = new HashSet(0);
	private Set collectPostTypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public PostType() {
	}

	/** full constructor */
	public PostType(String postType, Integer postStatus, Set posts,
			Set collectPostTypes) {
		this.postType = postType;
		this.postStatus = postStatus;
		this.posts = posts;
		this.collectPostTypes = collectPostTypes;
	}

	// Property accessors

	public Integer getPostTypeId() {
		return this.postTypeId;
	}

	public void setPostTypeId(Integer postTypeId) {
		this.postTypeId = postTypeId;
	}

	public String getPostType() {
		return this.postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public Integer getPostStatus() {
		return this.postStatus;
	}

	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}

	public Set getPosts() {
		return this.posts;
	}

	public void setPosts(Set posts) {
		this.posts = posts;
	}

	public Set getCollectPostTypes() {
		return this.collectPostTypes;
	}

	public void setCollectPostTypes(Set collectPostTypes) {
		this.collectPostTypes = collectPostTypes;
	}

}