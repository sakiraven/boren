package dao.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.PostTypeDao;
import entity.PostType;

@Repository
public class PostTypeDaoImpl extends HibernateDaoSupport implements PostTypeDao {
	@Autowired
	CommonQueryDao commonQueryDao;

	@Autowired
	ICommonCURD commonCURD;

	@Override
	public List<PostType> getAll() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from PostType where postStatus!=1";
		List<PostType> list = session.createQuery(hql).list();
		List list1 = new ArrayList();
		for (PostType postType : list) {
			PostType postType1 = new PostType();
			postType1.setPostStatus(postType.getPostStatus());
			postType1.setPostType(postType.getPostType());
			postType1.setPostTypeId(postType.getPostTypeId());
			list1.add(postType1);
		}
		return list1;
	}

	@Override
	public void delPostType(PostType postType) {
		PostType postType1 = (PostType) commonQueryDao.queryById(
				PostType.class, postType.getPostTypeId());
		postType1.setPostStatus(postType.getPostStatus());
		commonCURD.modifyObj(postType1, commonCURD.UPDATE);
	}

	@Override
	public void savePostType(PostType postType) {
		commonCURD.modifyObj(postType, commonCURD.SAVE);
	}

}
