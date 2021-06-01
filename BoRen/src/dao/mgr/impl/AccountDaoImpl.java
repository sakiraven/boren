package dao.mgr.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.AccountDao;
import entity.Account;
import entity.Admin;
import entity.UserInfo;

@Repository
public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {
	@Autowired
	ICommonCURD commonCURD;
	@Autowired
	CommonQueryDao commonQueryDao;

	private Integer currPage = 1;// 当前页数
	private Integer countSize;// 数据总条数
	private Integer countPage;// 总页数
	private Integer currSize;// 每页显示数量

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		if (currPage < 0) {
			this.currPage = 1;
		} else {
			this.currPage = currPage;
		}
	}

	public Integer getCountSize() {
		return countSize;
	}

	public void setCountSize(Integer countSize) {
		this.countSize = countSize;
		int size = this.currSize;
		this.countPage = countSize % this.currSize == 0 ? countSize
				/ this.currSize : (countSize / this.currSize) + 1;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCurrSize() {
		return currSize;
	}

	public void setCurrSize(Integer currSize) {
		this.currSize = currSize;
	}

	@Override
	public List<Account> getAll() {
		return commonQueryDao.queryAll(Account.class);
	}

	@Override
	public Account getAccount(int aid) {
		return (Account) commonQueryDao.queryById(Account.class, aid);
	}

	@Override
	public void updateAccount(Account account) {
		commonCURD.modifyObj(account, commonCURD.UPDATE);
	}

	@Override
	public Map<String, Object> findAll(Account account,
			AccountDaoImpl accountDao) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
