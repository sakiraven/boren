package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.AccountDao;
import dao.CookBookDao;
import dao.FansListDao;
import dao.UserInfoDao;

import entity.Account;
import entity.CookBook;
import entity.FansList;
import entity.UserInfo;

@Service
public class FansListService {
	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	private Map<String, Object> reMap;
	@Autowired
	private FansListDao fansListDao;
	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	public Object guanZhu(FansList fansList) {
		this.reMap = new HashMap<String, Object>();
		this.fansListDao.addUser(fansList);
		return this.reMap;
	}
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ

	

	

	
}
