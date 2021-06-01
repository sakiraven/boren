package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Account account;
	private StatusUser statusUser;
	private String userName;
	private String userEmial;
	private Integer userPhone;
	private String userSex;
	private String userImg;
	private Integer userEx;
	private Integer userCoin;
	private Integer userBalance;
	private Integer userVip;
	private Timestamp userTime;
	private Integer userSignIn;
	private Set collectPostTypes = new HashSet(0);
	private Set gmEmailsForEmailSendToId = new HashSet(0);
	private Set messageWalls = new HashSet(0);
	private Set gmEmailsForEmailSendId = new HashSet(0);
	private Set fansLists = new HashSet(0);
	private Set collectPosts = new HashSet(0);
	private Set vips = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set messagesForMsgSendToId = new HashSet(0);
	private Set commentTwoLevelsForCmmtSendToId = new HashSet(0);
	private Set posts = new HashSet(0);
	private Set cloudDocuments = new HashSet(0);
	private Set commentTwoLevelsForCmmtSendId = new HashSet(0);
	private Set messagesForMsgSendId = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Account account) {
		this.account = account;
	}

	/** full constructor */
	public UserInfo(Account account, StatusUser statusUser, String userName,
			String userEmial, Integer userPhone, String userSex,
			String userImg, Integer userEx, Integer userCoin,
			Integer userBalance, Integer userVip, Timestamp userTime,
			Integer userSignIn, Set collectPostTypes,
			Set gmEmailsForEmailSendToId, Set messageWalls,
			Set gmEmailsForEmailSendId, Set fansLists, Set collectPosts,
			Set vips, Set comments, Set messagesForMsgSendToId,
			Set commentTwoLevelsForCmmtSendToId, Set posts, Set cloudDocuments,
			Set commentTwoLevelsForCmmtSendId, Set messagesForMsgSendId) {
		this.account = account;
		this.statusUser = statusUser;
		this.userName = userName;
		this.userEmial = userEmial;
		this.userPhone = userPhone;
		this.userSex = userSex;
		this.userImg = userImg;
		this.userEx = userEx;
		this.userCoin = userCoin;
		this.userBalance = userBalance;
		this.userVip = userVip;
		this.userTime = userTime;
		this.userSignIn = userSignIn;
		this.collectPostTypes = collectPostTypes;
		this.gmEmailsForEmailSendToId = gmEmailsForEmailSendToId;
		this.messageWalls = messageWalls;
		this.gmEmailsForEmailSendId = gmEmailsForEmailSendId;
		this.fansLists = fansLists;
		this.collectPosts = collectPosts;
		this.vips = vips;
		this.comments = comments;
		this.messagesForMsgSendToId = messagesForMsgSendToId;
		this.commentTwoLevelsForCmmtSendToId = commentTwoLevelsForCmmtSendToId;
		this.posts = posts;
		this.cloudDocuments = cloudDocuments;
		this.commentTwoLevelsForCmmtSendId = commentTwoLevelsForCmmtSendId;
		this.messagesForMsgSendId = messagesForMsgSendId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public StatusUser getStatusUser() {
		return this.statusUser;
	}

	public void setStatusUser(StatusUser statusUser) {
		this.statusUser = statusUser;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmial() {
		return this.userEmial;
	}

	public void setUserEmial(String userEmial) {
		this.userEmial = userEmial;
	}

	public Integer getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserImg() {
		return this.userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public Integer getUserEx() {
		return this.userEx;
	}

	public void setUserEx(Integer userEx) {
		this.userEx = userEx;
	}

	public Integer getUserCoin() {
		return this.userCoin;
	}

	public void setUserCoin(Integer userCoin) {
		this.userCoin = userCoin;
	}

	public Integer getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}

	public Integer getUserVip() {
		return this.userVip;
	}

	public void setUserVip(Integer userVip) {
		this.userVip = userVip;
	}

	public Timestamp getUserTime() {
		return this.userTime;
	}

	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
	}

	public Integer getUserSignIn() {
		return this.userSignIn;
	}

	public void setUserSignIn(Integer userSignIn) {
		this.userSignIn = userSignIn;
	}

	public Set getCollectPostTypes() {
		return this.collectPostTypes;
	}

	public void setCollectPostTypes(Set collectPostTypes) {
		this.collectPostTypes = collectPostTypes;
	}

	public Set getGmEmailsForEmailSendToId() {
		return this.gmEmailsForEmailSendToId;
	}

	public void setGmEmailsForEmailSendToId(Set gmEmailsForEmailSendToId) {
		this.gmEmailsForEmailSendToId = gmEmailsForEmailSendToId;
	}

	public Set getMessageWalls() {
		return this.messageWalls;
	}

	public void setMessageWalls(Set messageWalls) {
		this.messageWalls = messageWalls;
	}

	public Set getGmEmailsForEmailSendId() {
		return this.gmEmailsForEmailSendId;
	}

	public void setGmEmailsForEmailSendId(Set gmEmailsForEmailSendId) {
		this.gmEmailsForEmailSendId = gmEmailsForEmailSendId;
	}

	public Set getFansLists() {
		return this.fansLists;
	}

	public void setFansLists(Set fansLists) {
		this.fansLists = fansLists;
	}

	public Set getCollectPosts() {
		return this.collectPosts;
	}

	public void setCollectPosts(Set collectPosts) {
		this.collectPosts = collectPosts;
	}

	public Set getVips() {
		return this.vips;
	}

	public void setVips(Set vips) {
		this.vips = vips;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getMessagesForMsgSendToId() {
		return this.messagesForMsgSendToId;
	}

	public void setMessagesForMsgSendToId(Set messagesForMsgSendToId) {
		this.messagesForMsgSendToId = messagesForMsgSendToId;
	}

	public Set getCommentTwoLevelsForCmmtSendToId() {
		return this.commentTwoLevelsForCmmtSendToId;
	}

	public void setCommentTwoLevelsForCmmtSendToId(
			Set commentTwoLevelsForCmmtSendToId) {
		this.commentTwoLevelsForCmmtSendToId = commentTwoLevelsForCmmtSendToId;
	}

	public Set getPosts() {
		return this.posts;
	}

	public void setPosts(Set posts) {
		this.posts = posts;
	}

	public Set getCloudDocuments() {
		return this.cloudDocuments;
	}

	public void setCloudDocuments(Set cloudDocuments) {
		this.cloudDocuments = cloudDocuments;
	}

	public Set getCommentTwoLevelsForCmmtSendId() {
		return this.commentTwoLevelsForCmmtSendId;
	}

	public void setCommentTwoLevelsForCmmtSendId(
			Set commentTwoLevelsForCmmtSendId) {
		this.commentTwoLevelsForCmmtSendId = commentTwoLevelsForCmmtSendId;
	}

	public Set getMessagesForMsgSendId() {
		return this.messagesForMsgSendId;
	}

	public void setMessagesForMsgSendId(Set messagesForMsgSendId) {
		this.messagesForMsgSendId = messagesForMsgSendId;
	}

}