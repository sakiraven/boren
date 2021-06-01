package entity;

/**
 * ShopList entity. @author MyEclipse Persistence Tools
 */

public class ShopList implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private String shopName;
	private Integer shopPrice;

	// Constructors

	/** default constructor */
	public ShopList() {
	}

	/** full constructor */
	public ShopList(String shopName, Integer shopPrice) {
		this.shopName = shopName;
		this.shopPrice = shopPrice;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Integer shopPrice) {
		this.shopPrice = shopPrice;
	}

}