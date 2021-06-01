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
public class AccountService {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private UserInfoDao userInfoDao;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	public Map clientLogin(Account account) {
		reMap = new HashMap<String, Object>();
		List<Account> getlt = accountDao.clientLogin(account);
		int acctId = getlt.isEmpty()?-1:getlt.get(0).getAcctId();
		reMap.put("acctId", acctId);
		return reMap;
	}
	
	public Map addAccount(Account account,UserInfo userInfo) {
		this.reMap = new HashMap<String, Object>();
		int result = 1;
		try {
			this.accountDao.addAccount(account);
			List<Account> getlt = this.accountDao.clientLogin(account);
			int acctId =getlt.isEmpty()?0:getlt.get(0).getAcctId();
			userInfo.setUserId(acctId);
			this.userInfoDao.addUserInfo(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("注册异常");
			result = -1;
		}
		this.reMap.put("result", result);
		return this.reMap;
	}
	public Map checkAccount(Account account) {
		this.reMap = new HashMap<String, Object>();
		int result = this.accountDao.checkAccount(account).isEmpty()?0:1;
		this.reMap.put("result", result);
		return this.reMap;
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆

	

	
}
