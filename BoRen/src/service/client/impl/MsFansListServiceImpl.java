package service.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdUserInfoDao;
import dao.client.impl.MdFansListDaoImpl;
import entity.Account;
import entity.FansList;
import entity.UserInfo;
@Service
public class MsFansListServiceImpl {
	@Autowired
	private MdFansListDaoImpl mdFansListDaoImpl;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	/**
	 * @param userId
	 * @return 粉丝数
	 */
	public int msFansNum(int userId){
		return this.mdFansListDaoImpl.mdFansNum(userId);
	}
	
	/**
	 * @param userId
	 * @return 关注数
	 */
	public int msGuanZhuNum(int userId){
		return this.mdFansListDaoImpl.mdGuanZhuNum(userId);
	}
	
	public void add(int guanZhuId,int fenSiId){
		/*Account acct = new Account(); 
		UserInfo guanZhu = new UserInfo();
		acct.setAcctId(guanZhuId);
		guanZhu.setAccount(acct);
		acct=new Account();
		UserInfo fenSi = new UserInfo();
		acct.setAcctId(fenSiId);
		fenSi.setAccount(acct);
		fenSi = this.mdUserInfoDaoImpl.mdQueryOne(fenSi);
		guanZhu =this.mdUserInfoDaoImpl.mdQueryOne(guanZhu);
		*/
		FansList fans = new FansList();
		fans.setFanFansUser(fenSiId);
		fans.setFanUser(guanZhuId);
		this.mdFansListDaoImpl.mdAdd(fans);
	}
}
