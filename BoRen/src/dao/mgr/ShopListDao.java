package dao.mgr;

import java.util.List;

import entity.ShopList;

public interface ShopListDao {
	// 获取所有商品
	List getAll();

	// 删除商品
	void delShopList(ShopList sl);

	// 添加商品
	void addShopList(ShopList sl);
}
