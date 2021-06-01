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
	private String postTitle;
	private String postText;
	private Timestamp postTime;
	private Integer postLoveNum;
	private Integer postVisitNum;
	private Integer postCoinNum;
	private Integer postStatus;
	private Integer postRelStatus;
	private String postImg;
	private Integer postTypeId;
	private Integer postUserId;
	private Integer currentPage=1;
	private Integer rows=10;
	private Integer firstPage=0;
	private Integer maxPage = 0;
	private Integer postCmmtNum;
	private String userName;
	private String userImg;
	private Integer userAge;
	private Integer userFansNum;
	private Integer userIsFans;
	private Integer fansId;
	private Integer userVip;
	private Timestamp userTime;
	private Integer postColl;
	private String postTypeName;
	private Integer sendId;
	private Integer sendToId;
	
	
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getSendToId() {
		return sendToId;
	}
	public void setSendToId(Integer sendToId) {
		this.sendToId = sendToId;
	}
	public String getPostTypeName() {
		return postTypeName;
	}
	public void setPostTypeName(String postTypeName) {
		this.postTypeName = postTypeName;
	}
	public Integer getPostColl() {
		return postColl;
	}
	public void setPostColl(Integer postColl) {
		this.postColl = postColl;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public Timestamp getUserTime() {
		return userTime;
	}
	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Integer getUserFansNum() {
		return userFansNum;
	}
	public void setUserFansNum(Integer userFansNum) {
		this.userFansNum = userFansNum;
	}
	public Integer getUserIsFans() {
		return userIsFans;
	}
	public void setUserIsFans(Integer userIsFans) {
		this.userIsFans = userIsFans;
	}
	public Integer getFansId() {
		return fansId;
	}
	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}
	public Integer getUserVip() {
		return userVip;
	}
	public void setUserVip(Integer userVip) {
		this.userVip = userVip;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPostCmmtNum() {
		return postCmmtNum;
	}
	public void setPostCmmtNum(Integer postCmmtNum) {
		this.postCmmtNum = postCmmtNum;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		/*if(currentPage!=0&&currentPage!=null)
			this.firstPage = (currentPage-1)*rows;*/
		if(currentPage!=0&&currentPage!=null)
			this.maxPage = this.rows*currentPage;
		this.currentPage = currentPage;
	}
	public Integer getPostTypeId() {
		return postTypeId;
	}
	public void setPostTypeId(Integer postTypeId) {
		this.postTypeId = postTypeId;
	}
	public Integer getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(Integer postUserId) {
		this.postUserId = postUserId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public Timestamp getPostTime() {
		return postTime;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	public Integer getPostLoveNum() {
		return postLoveNum;
	}
	public void setPostLoveNum(Integer postLoveNum) {
		this.postLoveNum = postLoveNum;
	}
	public Integer getPostVisitNum() {
		return postVisitNum;
	}
	public void setPostVisitNum(Integer postVisitNum) {
		this.postVisitNum = postVisitNum;
	}
	public Integer getPostCoinNum() {
		return postCoinNum;
	}
	public void setPostCoinNum(Integer postCoinNum) {
		this.postCoinNum = postCoinNum;
	}
	public Integer getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}
	public Integer getPostRelStatus() {
		return postRelStatus;
	}
	public void setPostRelStatus(Integer postRelStatus) {
		this.postRelStatus = postRelStatus;
	}
	public String getPostImg() {
		return postImg;
	}
	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}

	
}