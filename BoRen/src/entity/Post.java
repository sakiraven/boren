package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {

	// Fields

	private Integer postId;
	private PostType postType;
	private UserInfo userInfo;
	private String postTitle;
	private String postText;
	private Timestamp postTime;
	private Integer postLoveNum;
	private Integer postVisitNum;
	private Integer postCoinNum;
	private Integer postStatus;
	private Integer postRelStatus;
	private String postImg;
	private Set collectPosts = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set messages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** full constructor */
	public Post(PostType postType, UserInfo userInfo, String postTitle,
			String postText, Timestamp postTime, Integer postLoveNum,
			Integer postVisitNum, Integer postCoinNum, Integer postStatus,
			Integer postRelStatus, String postImg, Set collectPosts,
			Set comments, Set messages) {
		this.postType = postType;
		this.userInfo = userInfo;
		this.postTitle = postTitle;
		this.postText = postText;
		this.postTime = postTime;
		this.postLoveNum = postLoveNum;
		this.postVisitNum = postVisitNum;
		this.postCoinNum = postCoinNum;
		this.postStatus = postStatus;
		this.postRelStatus = postRelStatus;
		this.postImg = postImg;
		this.collectPosts = collectPosts;
		this.comments = comments;
		this.messages = messages;
	}

	// Property accessors

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public PostType getPostType() {
		return this.postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return this.postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Timestamp getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public Integer getPostLoveNum() {
		return this.postLoveNum;
	}

	public void setPostLoveNum(Integer postLoveNum) {
		this.postLoveNum = postLoveNum;
	}

	public Integer getPostVisitNum() {
		return this.postVisitNum;
	}

	public void setPostVisitNum(Integer postVisitNum) {
		this.postVisitNum = postVisitNum;
	}

	public Integer getPostCoinNum() {
		return this.postCoinNum;
	}

	public void setPostCoinNum(Integer postCoinNum) {
		this.postCoinNum = postCoinNum;
	}

	public Integer getPostStatus() {
		return this.postStatus;
	}

	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}

	public Integer getPostRelStatus() {
		return this.postRelStatus;
	}

	public void setPostRelStatus(Integer postRelStatus) {
		this.postRelStatus = postRelStatus;
	}

	public String getPostImg() {
		return this.postImg;
	}

	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}

	public Set getCollectPosts() {
		return this.collectPosts;
	}

	public void setCollectPosts(Set collectPosts) {
		this.collectPosts = collectPosts;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

}