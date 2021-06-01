package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdAccountDao;
import entity.Account;
import entity.UserInfo;
@Repository
public class MdAccountDaoImpl extends HibernateDaoSupport implements MdAccountDao{
	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	/**
	 * @param account
	 * @return 登录
	 */
	public Account mdLogin(Account account) {
		String queryString = "from Account where acct_name = ? and acct_pwd = ?";
		List <Account> getlt = this.getHibernateTemplate().find(queryString,account.getAcctName(),account.getAcctPwd());
		return getlt.isEmpty()?null:getlt.get(0);
	}
	/**
	 * @param account
	 *	注册账号部分 1/2
	 */
	public void mdAdd(Account account) throws Exception{
		this.commonCURD.modifyObj(account, this.commonCURD.SAVE);
	}
	
	
}
