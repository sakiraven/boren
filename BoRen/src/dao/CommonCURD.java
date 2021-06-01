package dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class CommonCURD extends HibernateDaoSupport implements ICommonCURD {
	@Transactional
	@Override
	public void modifyObj(Object obj, String type) {
		if(this.DEL.equals(type)){
			this.getHibernateTemplate().delete(obj);
		}else{
			this.getHibernateTemplate().saveOrUpdate(obj);
		}
 
	}

}
