package service.mgr;

import java.util.List;

import entity.CookBook;

public interface CookBookService {
	// 查询所有菜单
	List<CookBook> getAll();

	// 删除菜单
	String delCookBook(CookBook cookbook);

	// 添加菜单
	String saveCookBook(CookBook cookbook);

}
