package dao.client.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.ast.tree.RestrictableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdPostDao;
import entity.Post;
import entity.PostType;

@Repository
public class MdPostDaoImpl extends HibernateDaoSupport implements MdPostDao{
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	
	
	/**
	 * @return 查看所有帖子
	 */
	public List<Post> mdQueryAll(){
		return this.commonQueryDao.queryAll(Post.class);
	}
	/**
	 * @param post
	 * @return 搜索查询
	 */
	public Map<String, Object> mdQueryAll(Post post,int currentPage){
		DetachedCriteria crit = DetachedCriteria.forClass(Post.class);
		String test = post.getPostTitle();
		if(post.getPostTitle()!=null&&post.getPostTitle().length()!=0)
			crit.add(Restrictions.like("post_title", post.getPostTitle(),MatchMode.ANYWHERE));
		int count = this.getHibernateTemplate().findByCriteria(crit).size();
		//每页行数
		int rowNum = 4;
		//总页数
		int maxResults =(int)Math.ceil((double)count/(double)rowNum);
		//当前页数
		int firstResult = (currentPage-1)*rowNum;
		//获取list集合
		List<Post> getLt = this.getHibernateTemplate().findByCriteria(crit, firstResult, maxResults);
		//返回map集合
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("postList",getLt);
		reMap.put("currentPage", currentPage);
		reMap.put("countPage", maxResults);
		return reMap;
	}
	/**
	 * 创建帖子
	 */
	public void mdAdd(Post post) throws Exception{
		this.commonCURD.modifyObj(post, this.commonCURD.SAVE);
		
	}
	/**
	 * id查询 单项帖子
	 */
	/*public Post mdQueryOneById(Post post) {
		List<Post> reLt =(List<Post>) this.commonQueryDao.queryById(Post.class, post.getPostId());
		return reLt.isEmpty()?null:reLt.get(0);
	}*/
	public Post mdQueryOneById(Post post) {
		Post reLt = (Post)this.commonQueryDao.queryById(Post.class, post.getPostId());
		return reLt;
	}
	//更改表
	public void mdChange(Post post)throws Exception {
		this.commonCURD.modifyObj(post, this.commonCURD.UPDATE);
	}
	//查看类型帖子
	public Map<String , Object> mdQueryTypeAll(PostType postType,int currentPage,String postTitle) {
		DetachedCriteria crit = DetachedCriteria.forClass(Post.class);
		if(postType.getPostTypeId()!=null)
			crit.add(Restrictions.eq("postType.postTypeId", postType.getPostTypeId()));
		if(postTitle!=null&&postTitle!=""){
			crit.add(Restrictions.like("postTitle", postTitle,MatchMode.ANYWHERE));
			currentPage = 1;
		}
		crit.add(Restrictions.eq("postStatus", 0));
		crit.addOrder(Order.desc("postTime"));
		int rowNum=20;
		int count = this.getHibernateTemplate().findByCriteria(crit).size();
		int countPage = (int)Math.ceil((double)count/(double)rowNum);
		int max = rowNum*currentPage;
		List<Post> getlt = this.getHibernateTemplate().findByCriteria(crit, 0, max);
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("postList", getlt);
		reMap.put("currentPage", currentPage);
		return reMap;
	}
	//热度排序
	public List<Post> mdQueryLoveAll(PostType postType) {
		DetachedCriteria crit = DetachedCriteria.forClass(Post.class);
		if(postType.getPostTypeId() != null)
			crit.add(Restrictions.eq("postType.postTypeId", postType.getPostTypeId()));
		crit.add(Restrictions.eq("postStatus", 0));
		crit.addOrder(Order.desc("postLoveNum"));
		System.out.println("test:"+this.getHibernateTemplate().findByCriteria(crit));
		return this.getHibernateTemplate().findByCriteria(crit);
	}
}
