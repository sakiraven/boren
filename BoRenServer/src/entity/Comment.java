package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer cmmtId;
	private Integer cmmtUserId;
	private Integer cmmtPostId;
	private Integer cmmtFloor;
	private Timestamp cmmtTime;
	private Integer cmmtStatus;
	private String cmmtText;
	private Integer currentPage=1;
	private Integer rows=10;
	private Integer firstPage=0;
	private Integer maxPage = 0;
	private String userImg;
	private String userName;
	private Timestamp userTime;
	private Integer userAge;
	private Integer userFansNum;
	private Integer userVip;
	private Integer userIsFans;
	private Integer cmmtTwoNum;
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
	public Integer getCmmtTwoNum() {
		return cmmtTwoNum;
	}
	public void setCmmtTwoNum(Integer cmmtTwoNum) {
		this.cmmtTwoNum = cmmtTwoNum;
	}
	public Integer getUserIsFans() {
		return userIsFans;
	}
	public void setUserIsFans(Integer userIsFans) {
		this.userIsFans = userIsFans;
	}
	public Integer getUserVip() {
		return userVip;
	}
	public void setUserVip(Integer userVip) {
		this.userVip = userVip;
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
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getUserTime() {
		return userTime;
	}
	public void setUserTime(Timestamp userTime) {
		this.userTime = userTime;
	}
	public void setCurrentPage(Integer currentPage) {
		/*if(currentPage!=0&&currentPage!=null)
			this.firstPage = (currentPage-1)*rows;*/
		if(currentPage!=0&&currentPage!=null)
			this.maxPage = this.rows*currentPage;
		this.currentPage = currentPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public Integer getCmmtId() {
		return cmmtId;
	}
	public void setCmmtId(Integer cmmtId) {
		this.cmmtId = cmmtId;
	}
	public Integer getCmmtUserId() {
		return cmmtUserId;
	}
	public void setCmmtUserId(Integer cmmtUserId) {
		this.cmmtUserId = cmmtUserId;
	}
	public Integer getCmmtPostId() {
		return cmmtPostId;
	}
	public void setCmmtPostId(Integer cmmtPostId) {
		this.cmmtPostId = cmmtPostId;
	}
	public Integer getCmmtFloor() {
		return cmmtFloor;
	}
	public void setCmmtFloor(Integer cmmtFloor) {
		this.cmmtFloor = cmmtFloor;
	}
	public Timestamp getCmmtTime() {
		return cmmtTime;
	}
	public void setCmmtTime(Timestamp cmmtTime) {
		this.cmmtTime = cmmtTime;
	}
	public Integer getCmmtStatus() {
		return cmmtStatus;
	}
	public void setCmmtStatus(Integer cmmtStatus) {
		this.cmmtStatus = cmmtStatus;
	}
	public String getCmmtText() {
		return cmmtText;
	}
	public void setCmmtText(String cmmtText) {
		this.cmmtText = cmmtText;
	}
	
}