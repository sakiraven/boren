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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import dao.AccountDao;
import dao.CommentDao;
import dao.CommentTwoLevelDao;
import dao.CookBookDao;
import dao.FansListDao;
import dao.MessageDao;
import dao.UserInfoDao;
import dao.VipDao;

import entity.Account;
import entity.Comment;
import entity.CommentTwoLevel;
import entity.CookBook;
import entity.Message;
import entity.UserInfo;

@Service
public class CommentTwoLevelService {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private CommentTwoLevelDao commentTwoLevelDao;
	@Autowired
	private MessageDao messageDao;
	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
/*	public Map commentQueryByCmmtId(Comment comment) {
		this.reMap = new HashMap<String, Object>();
		List<Comment> getlt = this.commentDao.commentQueryByCmmtId(comment);
		for (Comment cmmt : getlt) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
			int age = Integer.parseInt(df.format(new Date()).toString())-Integer.parseInt(df.format(cmmt.getUserTime()).toString())+1;
			cmmt.setUserAge(age);
			cmmt.setUserVip(this.vipDao.isVip(cmmt.getCmmtUserId()));
			cmmt.setUserIsFans(this.fansListDao.isFans(comment.getCmmtUserId(), cmmt.getCmmtUserId()));
			cmmt.setUserFansNum(this.fansListDao.fanNums(cmmt.getCmmtUserId()));
		}
		this.reMap.put("commentList", getlt);
		int countPage =(int)Math.floor( (double)this.commentDao.commentSize(comment)/(double)comment.getRows());
		this.reMap.put("countPage",countPage);
		return this.reMap;
	}*/
	
	public Map queryCommentTwoLevel(CommentTwoLevel commentTwoLevel) {
		this.reMap = new HashMap<String, Object>();
		int countPage =(int)Math.ceil( (double)this.commentTwoLevelDao.commentTwoSize(commentTwoLevel)/(double)commentTwoLevel.getRows());
		System.out.println(this.commentTwoLevelDao.queryCmmtTwoOne(commentTwoLevel).size());
		this.reMap.put("commentTwoList", this.commentTwoLevelDao.queryCmmtTwoOne(commentTwoLevel));
		this.reMap.put("countPage", countPage);
		return this.reMap;
	}

	public Map addCommentTwoLevel(CommentTwoLevel commentTwoLevel) {
		this.reMap = new HashMap<String, Object>();
		int kill = KeyWordFileter.keyWordStart(commentTwoLevel.getCmmtTwoText());
		if(kill>0){
			this.reMap.put("result", -200);
			return this.reMap;
		}
		int result = 1;
		try {
			this.commentTwoLevelDao.addCommentTwoLevel(commentTwoLevel);
			Message message = new Message();
			message.setMsgType(1);
			message.setMsgSendId(commentTwoLevel.getSendId());
			message.setMsgSendToId(commentTwoLevel.getSendToId());
			message.setMsgPostId(commentTwoLevel.getCmmtPostId());
			message.setMsgCommentId(commentTwoLevel.getCmmtId());
			this.messageDao.addMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		this.reMap.put("result", result);
		return this.reMap;
	}

	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆

	
}
