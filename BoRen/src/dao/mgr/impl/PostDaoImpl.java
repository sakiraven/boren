package dao.mgr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.PostDao;
import entity.EntityUtil;
import entity.Post;
import entity.PostType;

@Repository
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
	private Integer currPage = 1;// 当前页数
	private Integer countSize;// 数据总条数
	private Integer countPage;// 总页数
	private Integer currSize;// 每页显示数量

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {

		if (currPage == null || currPage <= 0) {
			this.currPage = 1;
		} else if (currPage == null || currPage >= this.countPage) {
			this.currPage = this.countPage;
		} else {
			this.currPage = currPage;
		}
	}

	public Integer getCountSize() {
		return countSize;
	}

	public void setCountSize(Integer countSize) {
		this.countSize = countSize;
		this.countPage = countSize % this.currSize == 0 ? countSize
				/ this.currSize : (countSize / this.currSize) + 1;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCurrSize() {
		return currSize;
	}

	public void setCurrSize(Integer currSize) {
		this.currSize = currSize;
	}

	@Override
	public Map getAll(Integer currSize, Integer currPage, Post post) {
		HibernateTemplate temp = this.getHibernateTemplate();
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.openSession();
		Map<String, Object> myMap = new HashMap<String, Object>();
		String hql = this.strHql(post);
		int count = session.createQuery(hql).list().size();
		if (currPage != null) {
			this.setCurrSize(currSize);
			this.setCountSize(count);
			this.setCurrPage(currPage);
			int firstResult = (this.getCurrPage() - 1) * this.getCurrSize();
			hql = this.strHql(post);
			Query query = session.createQuery(hql);
			query.setFirstResult(firstResult);
			List<Post> myList = query.setMaxResults(this.getCurrSize()).list();
			List list = this.nextList(myList);
			myMap.put("list", list);
		} else {
			List<Post> myList = session.createQuery(hql).list();
			List list = this.nextList(myList);
			myMap.put("list", list);
		}
		myMap.put("currPage", this.getCurrPage());
		myMap.put("countPage", this.getCountPage());
		myMap.put("countSize", count);
		session.clear();
		session.close();
		return myMap;
	}

	@Override
	public void delPost(Post post) {
		HibernateTemplate temp = this.getHibernateTemplate();
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "from Post where postId=" + post.getPostId();
		Query query = session.createQuery(hql);
		Post post1 = (Post) query.list().get(0);
		post1.setPostStatus(1);
		session.update(post1);
		session.beginTransaction().commit();
		session.close();
	}

	// 拼接HQL
	private String strHql(Post post) {
		String hql = "from Post where 1=1 and postStatus!=1 and postType.postStatus!=1 ";
		Integer typeId = post.getPostType().getPostTypeId();
		if (typeId != null) {
			hql += " and postType.postTypeId  =" + typeId;
		}
		return hql;
	}

	// 循环遍历
	private List nextList(List<Post> myList) {
		List list = new ArrayList();
		for (Post post2 : myList) {
			EntityUtil entityUtil = new EntityUtil();
			PostType postType = new PostType();
			postType.setPostStatus(post2.getPostType().getPostStatus());
			postType.setPostType(post2.getPostType().getPostType());
			postType.setPostTypeId(post2.getPostType().getPostTypeId());
			Post post3 = new Post();
			post3.setPostId(post2.getPostId());
			post3.setPostStatus(post2.getPostStatus());
			post3.setPostText(post2.getPostText());
			post3.setPostTitle(post2.getPostTitle());
			entityUtil.setPost(post3);
			entityUtil.setPostType(postType);
			list.add(entityUtil);
		}
		return list;
	}

}
