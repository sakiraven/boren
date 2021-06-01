package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.client.MdCookBookDao;
import entity.CookBook;

@Repository
public class MdCookBookDaoImpl extends HibernateDaoSupport implements
		MdCookBookDao {
	@Autowired
	private CommonQueryDao commonQueryDaoImpl;
	//查看所有
	public List<CookBook> mdQueryAll() {
		return this.commonQueryDaoImpl.queryAll(CookBook.class);
	}

}
