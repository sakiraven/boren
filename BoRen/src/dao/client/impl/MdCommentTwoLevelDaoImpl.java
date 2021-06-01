package dao.client.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdCommentTwoLevelDao;
import entity.CommentTwoLevel;

@Repository
public class MdCommentTwoLevelDaoImpl extends HibernateDaoSupport implements
		MdCommentTwoLevelDao {
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	//查询
	public Map<String, Object> mdQueryByCmmtTwoId(CommentTwoLevel commtTwo,int currentPage) {
		Map<String, Object> reMap=null;
		try {
		DetachedCriteria crit = DetachedCriteria.forClass(CommentTwoLevel.class);
		int a = commtTwo.getComment().getCmmtId();
		if(commtTwo.getComment().getCmmtId()!=null&&commtTwo.getComment().getCmmtId()!=0)
			crit.add(Restrictions.eq("comment.cmmtId", commtTwo.getComment().getCmmtId()));
		int count = this.getHibernateTemplate().findByCriteria(crit).size();
		int rowNum = 4;
		int maxResults =(int) Math.ceil((double)count/(double)rowNum);
		int firstResult = (currentPage-1)*rowNum;
		List<CommentTwoLevel> getLt = this.getHibernateTemplate().findByCriteria(crit, firstResult, rowNum);
		reMap = new HashMap<String, Object>();
		reMap.put("commentTwoList", getLt);
		reMap.put("currentPage", currentPage);
		reMap.put("countPage", maxResults);
		} catch (Exception e) {
		}
		return reMap;
	}
	//添加二级评论
	public void mdCmmtTwoAdd(CommentTwoLevel commentTwoLevel)throws Exception {
		this.commonCURD.modifyObj(commentTwoLevel, this.commonCURD.SAVE);
	}
	//查看二级评论数量
	public int mdQueryNum(int cmmtId){
		String queryString = "from CommentTwoLevel where cmmt_Id="+cmmtId;
		return this.getHibernateTemplate().find(queryString).size();
	}
}
