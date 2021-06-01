package service.client.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.client.MsUserInfoService;

import dao.client.MdAccountDao;
import dao.client.MdUserInfoDao;
import dao.client.MdVipDao;
import entity.ShopList;
import entity.UserInfo;
import entity.Vip;
@Service
public class MsUserInfoServiceImpl implements MsUserInfoService {
	@Autowired
	private MdAccountDao mdAccountDaoImpl;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	@Autowired
	private MdVipDao mdVipDaoImpl;
	/**
	 * @param userInfo
	 * @return 查询单个用户
	 */
	public UserInfo msQueryOne(UserInfo userInfo){
		return this.mdUserInfoDaoImpl.mdQueryOne(userInfo);
	}
	/**
	 * @param userInfo
	 * 充值
	 */
	public int msReChange(UserInfo userInfo){
		UserInfo getUserInfo = this.mdUserInfoDaoImpl.mdQueryOne(userInfo);
		getUserInfo.setUserBalance(getUserInfo.getUserBalance()+userInfo.getUserBalance());
		try {
			this.mdUserInfoDaoImpl.mdChange(getUserInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	/**
	 * @param userInfo
	 * 消费
	 */
	public int msSpend(UserInfo userInfo,ShopList shopList){
		UserInfo getUserInfo = this.mdUserInfoDaoImpl.mdQueryOne(userInfo);
		if(!(getUserInfo.getUserBalance()>=userInfo.getUserBalance()))
			return 0;
		getUserInfo.setUserBalance(getUserInfo.getUserBalance()-userInfo.getUserBalance());
		try {
			this.mdUserInfoDaoImpl.mdChange(getUserInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			//商品列表管理
			this.thByShop(getUserInfo, shopList);
		}
		return 1;
	}
	//88888888888888888888888888类内方法88888888888888888888888888888888
	/**
	 * @param userInfo
	 * @param shopList
	 * @return 商品列表管理
	 */
	private int thByShop(UserInfo userInfo,ShopList shopList){
		int result = 0;
		if(shopList.getShopId()==1){
			result=this.thVip(userInfo);
		}
		return result;
	}
	/**
	 * @param userInfo
	 * @param shopList
	 * @return 购买会员
	 */
	private int thVip(UserInfo userInfo){
		try {
			Vip getVip = this.mdVipDaoImpl.mdQueryOne(userInfo);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar ca = Calendar.getInstance();
			if(getVip==null){
				ca.add(Calendar.MONTH, 1);
				Timestamp ts = Timestamp.valueOf(df.format(ca.getTime()));
				Vip vip = new Vip();
				vip.setUserInfo(userInfo);
				vip.setVipTime(ts);
				this.mdVipDaoImpl.mdSave(vip);
			}else{
				Date date = df.parse(getVip.getVipTime().toString());
				System.out.println(getVip.getVipTime().toString());
				ca.setTime(date);
				ca.add(Calendar.MONTH, 1);
				Timestamp ts = Timestamp.valueOf(df.format(ca.getTime()));
				getVip.setVipTime(ts);
				this.mdVipDaoImpl.mdChange(getVip);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
	/**
	 * @param userInfo
	 * @return 签到
	 */
	public int msSign(UserInfo userInfo){
		userInfo =  this.mdUserInfoDaoImpl.mdQueryOne(userInfo);
		int result = 1;
		if (userInfo.getUserSignIn()!=0) {
			return 0;
		}
		try {
			userInfo.setUserSignIn(1);
			userInfo.setUserEx(userInfo.getUserEx()+20);
			this.mdUserInfoDaoImpl.mdChange(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			result =-1;
		}
		return result;
	} 
}
