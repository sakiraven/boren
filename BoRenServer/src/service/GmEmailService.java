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
import dao.GmEmailDao;

import entity.Account;
import entity.CookBook;
import entity.GmEmail;
import entity.Message;
import entity.UserInfo;

@Service
public class GmEmailService {
	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	private Map<String, Object> reMap;
	@Autowired
	private GmEmailDao gmEmailDao;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	public Map queryGm(UserInfo userInfo) {
		reMap = new HashMap<String, Object>();
		reMap.put("gmList", gmEmailDao.queryGm(userInfo));
		return reMap;
	}
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ

	public Map addGm(GmEmail gmEmail) {
		reMap = new HashMap<String, Object>();
		int result = 0;
		try {
			result = 1;
			gmEmailDao.addGm(gmEmail);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		reMap.put("result", result);
		return reMap;
	}

	

}
