package dao.mgr;

import java.util.List;

import entity.CookBook;

public interface CookBookDao {
	// 查询所有菜单
	List getAll();

	// 删除菜单
	void delCookBook(CookBook cookbook);

	// 添加菜单
	void saveCookBook(CookBook cookbook);

}
