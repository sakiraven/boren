package entity;

import java.sql.Timestamp;

/**
 * CommentTwoLevel entity. @author MyEclipse Persistence Tools
 */

public class CommentTwoLevel implements java.io.Serializable {

	// Fields

	private Integer cmmtTwoId;
	private String cmmtTwoText;
	private Integer cmmtFloor;
	private Timestamp cmmtTime;
	private Integer cmmtTwoStatus;
	private Integer sendId;
	private Integer sendToId;
	private Integer cmmtId;
	private String sendName;
	private String sendToName;
	private String sendUserImg;
	private Integer cmmtPostId;
	
	
	private Integer firstResult;
	private Integer currentPage;
	private Integer countPage;
	private Integer rows=5;
	private Integer maxResults=this.rows;
	
	
	public Integer getCmmtPostId() {
		return cmmtPostId;
	}
	public void setCmmtPostId(Integer cmmtPostId) {
		this.cmmtPostId = cmmtPostId;
	}
	public String getSendUserImg() {
		return sendUserImg;
	}
	public void setSendUserImg(String sendUserImg) {
		this.sendUserImg = sendUserImg;
	}
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		if(currentPage!=null)
			this.firstResult = (currentPage-1) * this.rows;
		this.currentPage = currentPage;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getCmmtTwoId() {
		return cmmtTwoId;
	}
	public void setCmmtTwoId(Integer cmmtTwoId) {
		this.cmmtTwoId = cmmtTwoId;
	}
	public String getCmmtTwoText() {
		return cmmtTwoText;
	}
	public void setCmmtTwoText(String cmmtTwoText) {
		this.cmmtTwoText = cmmtTwoText;
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
	public Integer getCmmtTwoStatus() {
		return cmmtTwoStatus;
	}
	public void setCmmtTwoStatus(Integer cmmtTwoStatus) {
		this.cmmtTwoStatus = cmmtTwoStatus;
	}
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
	public Integer getCmmtId() {
		return cmmtId;
	}
	public void setCmmtId(Integer cmmtId) {
		this.cmmtId = cmmtId;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendToName() {
		return sendToName;
	}
	public void setSendToName(String sendToName) {
		this.sendToName = sendToName;
	}
	
	
	
}