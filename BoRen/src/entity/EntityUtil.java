package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Clown-MZ
 *
 */
/**
 * @author Clown-MZ
 *
 */
/**
 * @author Clown-MZ
 *
 */
/**
 * @author Clown-MZ
 *
 */
/**
 * @author Clown-MZ
 * 
 */
/**
 * @author Clown-MZ
 *
 */
public class EntityUtil {
	SimpleDateFormat sy = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	// *********帖子*********
	private Integer postId;
	private PostType postType;
	private String postTitle;
	private String postText;
	private String postTime;
	private Integer postLoveNum;
	private Integer postVisitNum;
	private Integer postCoinNum;
	private Integer postStatus;
	private Integer postRelStatus;
	private Integer postCmmtNum;
	private String postTypeName;
	private int postColl;
	private int postNum;

	// ******************帖子
	public EntityUtil(Integer postId, PostType postType, String postTitle,
			String postText, Timestamp postTime, Integer postLoveNum,
			Integer postVisitNum, Integer postCoinNum, Integer postStatus,
			Integer postRelStatus) {
		this.postCoinNum = postCoinNum;
		this.postId = postId;
		this.postLoveNum = postLoveNum;
		this.postRelStatus = postRelStatus;
		this.postStatus = postStatus;
		this.postVisitNum = postVisitNum;
		this.postTitle = postTitle;
		this.postType = postType;
		this.postText = postText;
		this.postTime = sy.format(postTime);

	}

	// ***********************用户
	private String userName;
	private int userID;
	private int acctId;
	private int userVip;
	private int userAge;
	private int postCollNum;
	private int postSend;
	private int userFansNum;
	private String userImg;
	private int userBalance;
	private String userSex;
	private int userCoin;
	private int userGuanZhu;
	private int userIsFans;
	private int userEx;
	private int userLevel;
	private int userStatus;
	private int userAdmin;
	// ********************************评论
	private Integer cmmtId;
	private Integer cmmtFloor;
	private String cmmtTime;
	private Integer cmmtStatus;
	private int cmmtTwoNum;
	private String cmmtText;
	// **************************************二级评论
	private Integer cmmtTwoId;
	private int sendToId;
	private String sendToName;
	private int sendId;
	private String sendName;
	private String cmmtTwoText;
	private String sendUserImg;
	private String sendToUserImg;
	// private Integer cmmtFloor;
	private String cmmtTwoTime;
	//*********************************************消息
	private int messageStatus;
	private int messageType;
	
	
	private String adminName;
	private ShopList shopList;
	private CookBook cookBook;
	private Notice notice;
	private GmEmail gmEmail;
	private EmailType emailType;
	private Vip vip;
	
	
	
	
	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(int userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public ShopList getShopList() {
		return shopList;
	}

	public void setShopList(ShopList shopList) {
		this.shopList = shopList;
	}

	public CookBook getCookBook() {
		return cookBook;
	}

	public void setCookBook(CookBook cookBook) {
		this.cookBook = cookBook;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public GmEmail getGmEmail() {
		return gmEmail;
	}

	public void setGmEmail(GmEmail gmEmail) {
		this.gmEmail = gmEmail;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	public int getUserEx() {
		return userEx;
	}

	public void setUserEx(int userEx) {
		this.userEx = userEx;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public int getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(int messageStatus) {
		this.messageStatus = messageStatus;
	}

	public int getUserIsFans() {
		return userIsFans;
	}

	public void setUserIsFans(int userIsFans) {
		this.userIsFans = userIsFans;
	}

	public int getUserGuanZhu() {
		return userGuanZhu;
	}

	public void setUserGuanZhu(int userGuanZhu) {
		this.userGuanZhu = userGuanZhu;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getUserCoin() {
		return userCoin;
	}

	public void setUserCoin(int userCoin) {
		this.userCoin = userCoin;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getPostCollNum() {
		return postCollNum;
	}

	public void setPostCollNum(int postCollNum) {
		this.postCollNum = postCollNum;
	}

	public int getPostSend() {
		return postSend;
	}

	public void setPostSend(int postSend) {
		this.postSend = postSend;
	}

	public int getUserFansNum() {
		return userFansNum;
	}

	public void setUserFansNum(int userFansNum) {
		this.userFansNum = userFansNum;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public int getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}

	public String getSendUserImg() {
		return sendUserImg;
	}

	public void setSendUserImg(String sendUserImg) {
		this.sendUserImg = sendUserImg;
	}

	public String getSendToUserImg() {
		return sendToUserImg;
	}

	public void setSendToUserImg(String sendToUserImg) {
		this.sendToUserImg = sendToUserImg;
	}

	public String getSendToName() {
		return sendToName;
	}

	public void setSendToName(String sendToName) {
		this.sendToName = sendToName;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public Integer getCmmtTwoId() {
		return cmmtTwoId;
	}

	public void setCmmtTwoId(Integer cmmtTwoId) {
		this.cmmtTwoId = cmmtTwoId;
	}

	public int getSendToId() {
		return sendToId;
	}

	public void setSendToId(int sendToId) {
		this.sendToId = sendToId;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public String getCmmtTwoText() {
		return cmmtTwoText;
	}

	public void setCmmtTwoText(String cmmtTwoText) {
		this.cmmtTwoText = cmmtTwoText;
	}

	public String getCmmtTwoTime() {
		return cmmtTwoTime;
	}

	public void setCmmtTwoTime(String cmmtTwoTime) {
		this.cmmtTwoTime = cmmtTwoTime;
	}

	public void setCmmtTime(String cmmtTime) {
		this.cmmtTime = cmmtTime;
	}

	public String getCmmtText() {
		return cmmtText;
	}

	public void setCmmtText(String cmmtText) {
		this.cmmtText = cmmtText;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Integer getPostCmmtNum() {
		return postCmmtNum;
	}

	public void setPostCmmtNum(Integer postCmmtNum) {
		this.postCmmtNum = postCmmtNum;
	}

	public int getUserVip() {
		return userVip;
	}

	public void setUserVip(int userVip) {
		this.userVip = userVip;
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	// 用户
	private UserInfo userInfo;
	// 管理
	private Admin admin;
	// 封禁
	private StatusUser statusUser;
	// 账号
	private Account account;
	// 帖子
	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public EntityUtil() {

	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
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

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {

		this.postTime = sy.format(postTime);
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

	// /用户
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public StatusUser getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(StatusUser statusUser) {
		this.statusUser = statusUser;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostTypeName() {
		return postTypeName;
	}

	public void setPostTypeName(String postTypeName) {
		this.postTypeName = postTypeName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Integer getCmmtId() {
		return cmmtId;
	}

	public void setCmmtId(Integer cmmtId) {
		this.cmmtId = cmmtId;
	}

	public Integer getCmmtFloor() {
		return cmmtFloor;
	}

	public void setCmmtFloor(Integer cmmtFloor) {
		this.cmmtFloor = cmmtFloor;
	}

	public String getCmmtTime() {
		return cmmtTime;
	}

	public void setCmmtTime(Timestamp cmmtTime) {
		this.cmmtTime = sy.format(cmmtTime);
	}

	public Integer getCmmtStatus() {
		return cmmtStatus;
	}

	public void setCmmtStatus(Integer cmmtStatus) {
		this.cmmtStatus = cmmtStatus;
	}

	public int getCmmtTwoNum() {
		return cmmtTwoNum;
	}

	public void setCmmtTwoNum(int cmmtTwoNum) {
		this.cmmtTwoNum = cmmtTwoNum;
	}

	public int getPostColl() {
		return postColl;
	}

	public void setPostColl(int postColl) {
		this.postColl = postColl;
	}

}
