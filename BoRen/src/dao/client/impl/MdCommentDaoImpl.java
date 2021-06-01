package dao.client.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdCommentDao;
import entity.Comment;
import entity.Post;
@Repository
public class MdCommentDaoImpl extends HibernateDaoSupport implements MdCommentDao {
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	//改变
	public void mdAdd(Comment comment) {
		this.commonCURD.modifyObj(comment, this.commonCURD.SAVE);
	}
	//查询帖子下评论个数
	public Map<String, Object> mdQueryByPostId(Comment comment,int currentPage) {
		DetachedCriteria crit = DetachedCriteria.forClass(Comment.class);
		crit.add(Restrictions.eq("post.postId", comment.getPost().getPostId()));
		crit.add(Restrictions.eq("cmmtStatus", 0));
		crit.addOrder(Order.asc("cmmtFloor"));
		List<Post> getlt=null;
		int maxResults=1;
		if(currentPage==-1)
			 getlt = this.getHibernateTemplate().findByCriteria(crit);
		else{
			int rowNum=4;
			int count = this.getHibernateTemplate().findByCriteria(crit).size();
			int max = rowNum*currentPage;
			maxResults =(int) Math.ceil((double)count/(double)rowNum);
			getlt = this.getHibernateTemplate().findByCriteria(crit, 0, max);
			System.out.println("添加后"+count);
		}
		Map<String, Object> reMap = new HashMap<String, Object>();
		
		reMap.put("commentList", getlt);
		reMap.put("countPage", maxResults);
		return reMap;
	}
}
