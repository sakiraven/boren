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
import dao.CollectPostDao;
import dao.CommentDao;
import dao.CookBookDao;
import dao.FansListDao;
import dao.MessageDao;
import dao.UserInfoDao;
import dao.VipDao;

import entity.Account;
import entity.CollectPost;
import entity.Comment;
import entity.CookBook;
import entity.Message;
import entity.UserInfo;

@Service
public class CollectPostService {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private CollectPostDao collectPostDao;
	//private 
	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	public Map addColl(CollectPost cp) {
		this.reMap = new HashMap<String, Object>();
		int size = this.collectPostDao.queryOneByPostId(cp).size();
		int result = 1;
		if(size>0){
			this.reMap.put("result", 0);
			return this.reMap;
		}
		this.collectPostDao.addColl(cp);
		this.reMap.put("result", result);
		return this.reMap;
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
	

	

}
