package service.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdCookBookDao;

import entity.CookBook;
import service.client.MsCookBookService;

@Service
public class MsCookBookServiceImpl implements MsCookBookService {
	@Autowired
	private MdCookBookDao mdCookBookDao;
	//查看所有菜谱
	public List<CookBook> msQueryAll() {
		return this.mdCookBookDao.mdQueryAll();
	}

}
