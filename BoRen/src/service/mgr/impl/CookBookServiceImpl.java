package service.mgr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.CookBookService;
import dao.mgr.CookBookDao;
import entity.CookBook;

@Service
public class CookBookServiceImpl implements CookBookService {
	@Autowired
	CookBookDao cookBookDaoImpl;

	@Override
	public List<CookBook> getAll() {
		return cookBookDaoImpl.getAll();
	}

	@Override
	public String delCookBook(CookBook cookbook) {
		if (cookbook.getCookId() != null) {
			cookBookDaoImpl.delCookBook(cookbook);
			return "删除成功!";
		}
		return "删除失败！";
	}

	@Override
	public String saveCookBook(CookBook cookbook) {
		if ((cookbook.getCookName() != null && !"".equals(cookbook
				.getCookName()))
				&& (cookbook.getCookImg() != null && !"".equals(cookbook
						.getCookImg()))
				&& (cookbook.getCookName() != null && !"".equals(cookbook
						.getCookName()))
				&& cookbook.getCookPrice() != null
				&& !"".equals(cookbook.getCookPrice())) {
			cookBookDaoImpl.saveCookBook(cookbook);
			return "添加成功!";
		}
		return "添加失败!";
	}
}
