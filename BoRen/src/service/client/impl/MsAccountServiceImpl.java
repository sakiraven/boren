package service.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.client.MsAccountService;

import dao.client.MdAccountDao;
import dao.client.MdUserInfoDao;
import entity.Account;
import entity.UserInfo;
@Service
public class MsAccountServiceImpl implements MsAccountService{
	@Autowired
	private MdAccountDao mdAccountDaoImpl;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	/**
	 * @param account
	 * @return 登录
	 */
	public Account msLogin(Account account){
		return this.mdAccountDaoImpl.mdLogin(account);
	}
	/**
	 * @param account
	 *	注册账号部分
	 */
	public int msAdd(Account account,UserInfo userInfo){
		try {
			this.mdAccountDaoImpl.mdAdd(account);
			Account getAccount = this.mdAccountDaoImpl.mdLogin(account);
			userInfo.setAccount(getAccount);
			this.mdUserInfoDaoImpl.mdAdd(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
