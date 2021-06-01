package entity;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private String noticeTitle;
	private String noticeText;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(String noticeTitle, String noticeText) {
		this.noticeTitle = noticeTitle;
		this.noticeText = noticeText;
	}

	// Property accessors

	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeText() {
		return this.noticeText;
	}

	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}

}