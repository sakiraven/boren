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
import dao.UserInfoDao;

import entity.Account;
import entity.CookBook;
import entity.UserInfo;

@Service
public class UserInfoService {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private UserInfoDao userInfoDao;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	public Map sign(UserInfo userInfo) {
		reMap = new HashMap<String, Object>();
		int result = 0;
		int bool = this.userInfoDao.queryOneInfo(userInfo).get(0).getUserSignIn();
		try {
			if(bool!=1)
				userInfoDao.sign(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
			System.out.println("签到异常");
		}finally{
			if(bool!=1)
				result = 1;
		}
		reMap.put("result", result);
		return reMap;
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆


}
