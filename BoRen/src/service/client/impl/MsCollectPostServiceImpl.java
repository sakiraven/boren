package service.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdPostDao;
import dao.client.MdUserInfoDao;
import dao.client.impl.MdCollectPostDaoImpl;
import dao.client.impl.MdPostDaoImpl;
import entity.Account;
import entity.CollectPost;
import entity.Post;
import entity.UserInfo;

@Service
public class MsCollectPostServiceImpl {
	@Autowired
	private MdCollectPostDaoImpl mdCollectPostDao;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	@Autowired
	private MdPostDao mdPostDaoImpl;
	/**
	 * @param collPost
	 * 添加收藏
	 */
	public int  addCollPost(int postId,int acctId){
		int result = this.mdCollectPostDao.mdIsCollPost(postId,acctId).size();
		
		if(result!=0){
			return result;
		}else{
			UserInfo userInfo = new UserInfo();
			Account acct = new Account();
			acct.setAcctId(acctId);
			userInfo.setAccount(acct);
			userInfo = this.mdUserInfoDaoImpl.mdQueryOne(userInfo);
			Post post = new Post();
			post.setPostId(postId);
			post = this.mdPostDaoImpl.mdQueryOneById(post);
			CollectPost collPost = new CollectPost();
			collPost.setPost(post);
			collPost.setUserInfo(userInfo);
			this.mdCollectPostDao.add(collPost);
		}
		
		return result;
	}
}
