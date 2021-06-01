package service.mgr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.ShopListService;
import dao.mgr.ShopListDao;
import entity.ShopList;

@Service
public class ShopListServiceImpl implements ShopListService {
	@Autowired
	ShopListDao shopListDaoImpl;

	@Override
	public List<ShopList> getAll() {
		return shopListDaoImpl.getAll();
	}

	@Override
	public String delShopList(ShopList sl) {
		if (sl.getShopId() != null) {
			shopListDaoImpl.delShopList(sl);
			return "删除成功！";
		}
		return "删除失败！";
	}

	@Override
	public String addShopList(ShopList sl) {
		if ((sl.getShopName() != null && !sl.getShopName().equals(""))
				&& (sl.getShopPrice() != null && !sl.getShopPrice().equals(""))) {
			shopListDaoImpl.addShopList(sl);
			return "添加成功";
		}
		return "添加失败!";
	}

}
