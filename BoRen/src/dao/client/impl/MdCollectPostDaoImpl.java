package dao.client.impl;

import java.util.List;

import org.aspectj.bridge.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.ICommonCURD;
import entity.CollectPost;
import entity.Post;

@Repository
public class MdCollectPostDaoImpl extends HibernateDaoSupport {
	@Autowired
	private ICommonCURD commandCURD;
	//添加收藏
	public void add(CollectPost collPost){
		this.commandCURD.modifyObj(collPost, this.commandCURD.SAVE);
	}
	
	/**
	 * @param userId
	 * @return 用户收藏的帖子个数
	 */
	public int mdCollPostNum(Integer postId) {
		String queryString = "from CollectPost where coll_post_post_id="+postId;
		return this.getHibernateTemplate().find(queryString).size();
	}
	public List<Post> mdIsCollPost(int postId,int userId){
		String queryString = "from CollectPost where coll_post_user_id="+userId+" and  coll_post_post_id="+postId;
		return this.getHibernateTemplate().find(queryString);
	}
}
