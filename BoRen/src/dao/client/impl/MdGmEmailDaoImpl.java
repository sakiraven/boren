package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdGmEmailDao;
import entity.GmEmail;

@Repository
public class MdGmEmailDaoImpl extends HibernateDaoSupport implements MdGmEmailDao{
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	//添加gm表
	public void mdAdd(GmEmail gmEmail)throws Exception {
		this.commonCURD.modifyObj(gmEmail, this.commonCURD.SAVE);
	}
	//改变gm表
	public void mdChange(GmEmail gmEmail) throws Exception {
		this.commonCURD.modifyObj(gmEmail, this.commonCURD.UPDATE);
	}
	//用户id查询表
	public List<GmEmail> mdQueryUserInfo(GmEmail gmEmail) {
		String queryString = "from GmEmail where  email_send_to_id = ?";
		return this.getHibernateTemplate().find(queryString, gmEmail.getUserInfoByEmailSendToId().getAccount().getAcctId());
	}
	//邮件id查询
	public GmEmail mdQueryById(GmEmail gmEmail) {
		GmEmail reObj = (GmEmail)this.commonQueryDao.queryById(GmEmail.class, gmEmail.getEmailId());
		return reObj;
	}
	
}
