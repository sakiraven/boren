package service.client.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jmx.snmp.Timestamp;

import service.client.MsPostService;
import util.KeyWordFileter;

import dao.client.MdMessageDao;
import dao.client.MdPostDao;
import dao.client.MdUserInfoDao;
import dao.client.impl.MdCollectPostDaoImpl;
import dao.client.impl.MdFansListDaoImpl;
import dao.client.impl.MdPostDaoImpl;
import entity.Account;
import entity.EntityUtil;
import entity.Message;
import entity.Post;
import entity.PostType;
import entity.UserInfo;

@Service
public class MsPostServiceImpl implements MsPostService {
	@Autowired
	private MdPostDao mdPostDaoImpl;
	@Autowired
	private MdCollectPostDaoImpl mdCollectPostDao;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	@Autowired
	private MdFansListDaoImpl mdFansListDaoImpl;
	@Autowired
	private MdMessageDao mdMessageDaoImpl;
	/**
	 * @return 查看所有帖子
	 */
	public List<Post> msQueryAll(){
		return this.mdPostDaoImpl.mdQueryAll();
	}
	/**
	 * @param post
	 * @return 按名称查询
	 */
	public Map<String, Object> msQueryAllLike(Post post,int currentPage){
		return this.mdPostDaoImpl.mdQueryAll(post,currentPage);
	}
	/**
	 * 创建帖子
	 */
	public int msAdd(Post post){
		int result = 1;
		//处理敏感词
		int kill = 0;
		kill += KeyWordFileter.keyWordStart(post.getPostText());
		kill += KeyWordFileter.keyWordStart(post.getPostTitle());
		System.out.println(kill);
		if(kill!=0)
			return -200;
		try {
			UserInfo userInfo = new UserInfo(); 
			Account account = new Account();
			account.setAcctId(post.getUserInfo().getAccount().getAcctId());
			userInfo.setAccount(account);
			post.setUserInfo(this.mdUserInfoDaoImpl.mdQueryOne(userInfo));
			this.mdPostDaoImpl.mdAdd(post);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	/**
	 * id查询
	 */
	public List<EntityUtil>  msQueryOneById(Post post,int fansId) {
		Post rePost = this.mdPostDaoImpl.mdQueryOneById(post);
		rePost.setPostVisitNum(rePost.getPostVisitNum()+1);
		List<Post> getlt1= new ArrayList<Post>();
		getlt1.add(rePost);
		List<EntityUtil> reLt = this.untilPost(getlt1,1,fansId);
		try {
			this.mdPostDaoImpl.mdChange(rePost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reLt;
		
	}
	//点赞
	public int msLove(Post post,int sendToId,int sendId) {
		Post getPost = this.mdPostDaoImpl.mdQueryOneById(post);
		getPost.setPostLoveNum(getPost.getPostLoveNum()+1);
		Account acct = new Account();
		UserInfo sendUser = new UserInfo();
		acct.setAcctId(sendId);
		sendUser.setAccount(acct);
		UserInfo sendToUser = new UserInfo();
		acct= new Account();
		acct.setAcctId(sendToId);
		sendToUser.setAccount(acct);
		
		UserInfo send = this.mdUserInfoDaoImpl.mdQueryOne(sendUser);
		UserInfo sendTo = this.mdUserInfoDaoImpl.mdQueryOne(sendToUser);
		Message message = new Message();
		message.setUserInfoByMsgSendId(send);
		message.setUserInfoByMsgSendToId(sendTo);
		message.setMsgType(2);
		message.setPost(getPost);
		this.mdMessageDaoImpl.mdAddMessage(message);
		int result = 1;
		try {
			this.mdPostDaoImpl.mdChange(getPost);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	//类型查询
	public Map<String, Object> msQueryType(PostType postType,int currentPage,String postTitle) {
		Map<String,Object> reMap = this.mdPostDaoImpl.mdQueryTypeAll(postType,currentPage,postTitle);
		List<Post> getlt = (List<Post>)reMap.get("postList");
		List<EntityUtil> getLt = this.untilPost(getlt,0,0);
		reMap.remove("postList");
		reMap.put("postList", getLt);
		reMap.put("hot", this.msQueryLoveType(postType));
		return reMap;
	}
	
	//热度排序
	public List<EntityUtil> msQueryLoveType(PostType postType) {
		List<Post> getlt = this.mdPostDaoImpl.mdQueryLoveAll(postType);
		List<EntityUtil> reLt = this.untilPost(getlt,0,0);
		return reLt;
	}
	//封装帖子
	private List<EntityUtil>  untilPost(List<Post> getlt,int type,int fansId){
		List<EntityUtil> reLt = new ArrayList<EntityUtil>();
		for (Post post : getlt) {
			EntityUtil enl = new EntityUtil(post.getPostId(),post.getPostType()
					,post.getPostTitle(),post.getPostText(),post.getPostTime()
					,post.getPostLoveNum(),post.getPostVisitNum(),post.getPostCoinNum()
					,post.getPostStatus(),post.getPostRelStatus());
			enl.setUserName(post.getUserInfo().getUserName());
			enl.setPostCmmtNum(post.getComments().size());
			enl.setPostTypeName(post.getPostType().getPostType());
			enl.setUserVip(post.getUserInfo().getVips().size());
			SimpleDateFormat sy=new SimpleDateFormat("yyyy");
			enl.setAcctId(post.getUserInfo().getAccount().getAcctId());
			enl.setSendUserImg(post.getUserInfo().getUserImg());
			enl.setUserFansNum(this.mdFansListDaoImpl.mdFansNum(post.getUserInfo().getAccount().getAcctId()));
			enl.setUserIsFans(this.mdFansListDaoImpl.mdIsFan(fansId, post.getUserInfo().getAccount().getAcctId()));
			if(type==1){
				int age = Integer.parseInt(sy.format(new Date()).toString())-Integer.parseInt(sy.format(post.getPostTime()).toString())+1;
				enl.setPostColl(this.mdCollectPostDao.mdCollPostNum(post.getPostId()));
				enl.setUserAge(age);
			}
			enl.setPostCoinNum(post.getPostCoinNum());
			reLt.add(enl);
		}
		return reLt;
	}
	//投币
	public int msTouB(int postId,int sendId,int sendToId) {
		//*******************账号封装
		Account acct = new Account();
		UserInfo sendUserInfo = new UserInfo();
		acct.setAcctId(sendId);
		sendUserInfo.setAccount(acct);
		UserInfo sendToUserInfo = new UserInfo();
		acct = new Account();
		acct.setAcctId(sendToId);
		sendToUserInfo.setAccount(acct);
		//账号封装*******************
		Post byPost = new Post();
		byPost.setPostId(postId);
		byPost =this.mdPostDaoImpl.mdQueryOneById(byPost);
		UserInfo sendUser = this.mdUserInfoDaoImpl.mdQueryOne(sendUserInfo);
		UserInfo sendToUser = this.mdUserInfoDaoImpl.mdQueryOne(sendToUserInfo);
		int result = -1;
		if (sendUser.getUserCoin()==0) {
			return result;
		}
		sendToUser.setUserCoin(sendToUser.getUserCoin()+1);
		sendUser.setUserCoin(sendUser.getUserCoin()-1);
		try {
			this.mdUserInfoDaoImpl.mdChange(sendToUser);
			this.mdUserInfoDaoImpl.mdChange(sendUser);
			byPost.setPostCoinNum(byPost.getPostCoinNum()+1);
			this.mdPostDaoImpl.mdChange(byPost);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			result = byPost.getPostCoinNum();
		}
		return result;
	}
}

















