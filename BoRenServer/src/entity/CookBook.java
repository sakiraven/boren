package entity;

/**
 * CookBook entity. @author MyEclipse Persistence Tools
 */

public class CookBook implements java.io.Serializable {

	// Fields

	private Integer cookId;
	private String cookImg;
	private String cookName;
	private Integer cookPrice;

	// Constructors

	/** default constructor */
	public CookBook() {
	}

	/** full constructor */
	public CookBook(String cookImg, String cookName, Integer cookPrice) {
		this.cookImg = cookImg;
		this.cookName = cookName;
		this.cookPrice = cookPrice;
	}

	// Property accessors

	public Integer getCookId() {
		return this.cookId;
	}

	public void setCookId(Integer cookId) {
		this.cookId = cookId;
	}

	public String getCookImg() {
		return this.cookImg;
	}

	public void setCookImg(String cookImg) {
		this.cookImg = cookImg;
	}

	public String getCookName() {
		return this.cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	public Integer getCookPrice() {
		return this.cookPrice;
	}

	public void setCookPrice(Integer cookPrice) {
		this.cookPrice = cookPrice;
	}

}