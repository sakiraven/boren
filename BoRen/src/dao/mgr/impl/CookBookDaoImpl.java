package dao.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.CookBookDao;
import entity.CookBook;
import entity.EntityUtil;
import entity.Notice;

@Repository
public class CookBookDaoImpl extends HibernateDaoSupport implements CookBookDao {
	@Autowired
	CommonQueryDao commonQueryDao;
	@Autowired
	ICommonCURD commonCURD;

	@Override
	public List getAll() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from CookBook where 1=1";
		List<CookBook> list = session.createQuery(hql).list();
		List list1 = new ArrayList<CookBook>();
		for (CookBook cookBook : list) {
			EntityUtil entity = new EntityUtil();
			CookBook cook = new CookBook();
			cook.setCookId(cookBook.getCookId());
			cook.setCookImg(cookBook.getCookImg());
			cook.setCookName(cookBook.getCookName());
			cook.setCookPrice(cookBook.getCookPrice());
			entity.setCookBook(cook);
			list1.add(entity);
		}
		return list1;
	}

	@Override
	public void delCookBook(CookBook cookbook) {
		commonCURD.modifyObj(cookbook, commonCURD.DEL);
	}

	@Override
	public void saveCookBook(CookBook cookbook) {
		commonCURD.modifyObj(cookbook, commonCURD.SAVE);
	}

}
