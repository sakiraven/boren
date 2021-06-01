package service.client;

import java.util.List;

import entity.CookBook;

public interface MsCookBookService {
	/**
	 * @return 查看所有菜谱
	 */
	List<CookBook> msQueryAll();
}
