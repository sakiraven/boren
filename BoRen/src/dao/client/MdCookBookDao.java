package dao.client;

import java.util.List;

import entity.CookBook;

public interface MdCookBookDao {
	/**
	 * @return 查看所有
	 */
	List<CookBook> mdQueryAll();
}
