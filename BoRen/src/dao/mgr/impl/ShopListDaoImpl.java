package dao.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.ShopListDao;
import entity.CookBook;
import entity.EntityUtil;
import entity.ShopList;

@Repository
public class ShopListDaoImpl extends HibernateDaoSupport implements ShopListDao {
	@Autowired
	CommonQueryDao commonQueryDao;

	@Autowired
	ICommonCURD commonCURD;

	@Override
	public List getAll() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from ShopList where 1=1";
		List<ShopList> list = session.createQuery(hql).list();
		List list1 = new ArrayList();
		for (ShopList shopList : list) {
			ShopList shopList1 = new ShopList();
			EntityUtil entity = new EntityUtil();
			shopList1.setShopId(shopList.getShopId());
			shopList1.setShopName(shopList.getShopName());
			shopList1.setShopPrice(shopList.getShopPrice());
			entity.setShopList(shopList1);
			list1.add(entity);
		}
		return list1;
	}

	@Override
	public void delShopList(ShopList sl) {
		commonCURD.modifyObj(sl, commonCURD.DEL);
	}

	@Override
	public void addShopList(ShopList sl) {
		commonCURD.modifyObj(sl, commonCURD.SAVE);
	}

}
