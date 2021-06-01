package dao.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.ICommonCURD;
import entity.FansList;
@Repository
public class MdFansListDaoImpl extends HibernateDaoSupport{
	@Autowired
	private ICommonCURD commonCURD;
	/**
	 * @param userId
	 * @return 粉丝数
	 */
	public int mdFansNum(int userId){
		String queryString = "from FansList where fan_user="+userId;
		return this.getHibernateTemplate().find(queryString).size();
	}
	
	/**
	 * @param userId
	 * @return 关注数
	 */
	public int mdGuanZhuNum(int userId){
		String queryString = "from FansList where fan_fans_user="+userId;
		return this.getHibernateTemplate().find(queryString).size();
	}
	
	/**
	 * @param fansUserId
	 * @param userId
	 * @return 判断是不是粉丝
	 */
	public int mdIsFan(int fansUserId,int userId){
		String queryString = "from FansList where fan_fans_user="+fansUserId+" and fan_user="+userId;
		int result = this.getHibernateTemplate().find(queryString).size();
		return result;
	}
	/**
	 * @param fans
	 * 添加关注列表
	 */
	public void mdAdd(FansList fans){
		this.commonCURD.modifyObj(fans, this.commonCURD.SAVE);
	}
}
