package dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CommonQueryDao extends HibernateDaoSupport{
	public List queryAll(Class clazz){
		return this.getHibernateTemplate().find("from "+clazz.getName());
	}
	
	public Object queryById(Class clazz,Serializable id){
		return this.getHibernateTemplate().get(clazz, id);
	}
}
