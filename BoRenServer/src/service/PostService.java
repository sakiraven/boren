package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import util.KeyWordFileter;

import dao.FansListDao;
import dao.PostDao;
import dao.UserInfoDao;
import dao.VipDao;

import entity.Post;
import entity.UserInfo;
@Service
public class PostService {
//👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private PostDao postDao;
	@Autowired
	private VipDao vipDao;
	@Autowired
	private FansListDao fansListDao;
	@Autowired
	private UserInfoDao userInfoDao;
//👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆
	
	
//👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	public Map postLoveQuery(Post post){
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("postList", this.postDao.postLoveQuery(post));
		return this.reMap;
	}

	public Map postTypeQuery(Post post) {
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("postList", this.postDao.postTypeQuery(post));
		this.reMap.put("hot", this.postDao.postLoveQuery(post));
		this.reMap.put("currentPage", post.getCurrentPage()+1);
		this.reMap.put("countRow", this.postDao.postSize(post));
		return this.reMap;
	}

	public Map postAdd(Post post) {
		int kill = KeyWordFileter.keyWordStart(post.getPostText());
		kill +=KeyWordFileter.keyWordStart(post.getPostTitle());
		if(kill != 0){
			this.reMap.put("result", -200);
			return this.reMap;
		}
		this.reMap = new HashMap<String, Object>();
		int result = 1;
		try {
			this.postDao.postAdd(post);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
			System.out.println("创建帖子异常");
		}
		this.reMap.put("result",result);
		
		return this.reMap;
	}
	
	public Map postQueryOneById(Post post) {
		this.reMap = new HashMap<String, Object>();
		List<Post> getlt = this.postDao.postQueryOneById(post);
		for (Post pst : getlt) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
			int age = Integer.parseInt(df.format(new Date()).toString())-Integer.parseInt(df.format(pst.getUserTime()).toString())+1;
			pst.setUserAge(age);
			pst.setUserVip(this.vipDao.isVip(pst.getPostUserId()));
			pst.setUserIsFans(this.fansListDao.isFans(post.getFansId(), pst.getPostUserId()));
			pst.setUserFansNum(this.fansListDao.fanNums(pst.getPostUserId()));
		}
		this.reMap.put("postList",getlt);
		return this.reMap;
	}
	
	public Map postTouB(Post post) {
		this.reMap = new HashMap<String, Object>();
		UserInfo userInfo = new UserInfo();
		userInfo.setAcctId(post.getSendId());
		if(this.userInfoDao.queryOneInfo(userInfo).get(0).getUserCoin()-1<0){
			this.reMap.put("result", 0);
			return this.reMap;
		}
		UserInfo send = new UserInfo();
		UserInfo sendTo = new UserInfo();
		
		send.setUserCoin(-1);
		send.setAcctId(post.getSendId());
		sendTo.setUserCoin(1);
		sendTo.setAcctId(post.getSendToId());
		this.userInfoDao.updateB(send);
		this.userInfoDao.updateB(sendTo);
		this.postDao.updateB(post);
		this.reMap.put("result", this.postDao.postBQuery(post).get(0).getPostCoinNum());
		return this.reMap;
	}
	public Map postLove(Post post) {
		this.reMap = new HashMap<String, Object>();
		this.postDao.postLove(post);
		this.reMap.put("result", "点赞成功");
		return this.reMap;
	}
//👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆

	

	

	


	
}
