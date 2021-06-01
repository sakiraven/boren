package service.mgr;

import java.util.List;

import entity.ShopList;

public interface ShopListService {
	// 获取所有商品
	List<ShopList> getAll();

	// 删除商品
	String delShopList(ShopList sl);

	// 添加商品
	String addShopList(ShopList sl);
}
