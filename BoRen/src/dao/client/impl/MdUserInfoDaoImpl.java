package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdUserInfoDao;
import entity.Account;
import entity.UserInfo;

@Repository
public class MdUserInfoDaoImpl extends HibernateDaoSupport implements MdUserInfoDao{
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	
	/**
	 * @param userInfo
	 * 插入用户信息
	 */
	public void mdAdd(UserInfo userInfo) throws Exception{
		this.commonCURD.modifyObj(userInfo, this.commonCURD.SAVE);
	}
	
	/**
	 * @param userInfo
	 * 更改用户信息
	 */
	public void mdChange(UserInfo userInfo) throws Exception{
		this.commonCURD.modifyObj(userInfo, this.commonCURD.UPDATE);
	}
	
	/**
	 * @param userInfo
	 * @return 查询单个用户信息
	 */
	public UserInfo mdQueryOne(UserInfo userInfo){
		UserInfo  getObj = (UserInfo)this.commonQueryDao.queryById(UserInfo.class, userInfo.getAccount().getAcctId());
		return getObj;
	}
	public int mdFengJin(int acctId){
		String queryString = "from UserInfo where user_status=1 and user_id="+acctId;
		return this.getHibernateTemplate().find(queryString).size()==0?0:1;
	}
	
}
