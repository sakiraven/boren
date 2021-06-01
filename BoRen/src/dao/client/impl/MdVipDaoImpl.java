package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdVipDao;
import entity.UserInfo;
import entity.Vip;

@Repository
public class MdVipDaoImpl extends HibernateDaoSupport implements MdVipDao{
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	
	/**
	 * @param userInfo
	 * 更改vip表
	 */
	public void mdChange(Vip vip){
		this.commonCURD.modifyObj(vip, this.commonCURD.UPDATE);
	}
	/**
	 * @param userInfo
	 * 插入vip表
	 */
	public void mdSave(Vip vip){
		this.commonCURD.modifyObj(vip, this.commonCURD.SAVE);
	}
	/**
	 * @param userInfo
	 * @return 查看单个用户
	 */
	public Vip mdQueryOne(UserInfo userInfo){
		String queryString = "from Vip where vip_user_id = ?";
		List<Vip> getlt = this.getHibernateTemplate().find(queryString,userInfo.getUserId());
		return getlt.isEmpty()?null:getlt.get(0);
	}
}
