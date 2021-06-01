package service.mgr.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.AccountService;
import dao.mgr.AccountDao;
import dao.mgr.AdminDao;
import dao.mgr.impl.AccountDaoImpl;
import entity.Account;
import entity.Admin;
import entity.EntityUtil;
import entity.UserInfo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDaoImpl;
	@Autowired
	AdminDao adminDaoImpl;

	@Override
	public List<Account> getAll() {
		return accountDaoImpl.getAll();
	}

	@Override
	public Account getAccount(int aid) {
		return accountDaoImpl.getAccount(aid);
	}

	@Override
	public void updateAccount(Integer userInfoId, Integer adminId) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		try {
			Admin admin = adminDaoImpl.getAdmin(adminId);
			Account account = accountDaoImpl.getAccount(userInfoId);
			account.setAdmin(admin);
			accountDaoImpl.updateAccount(account);
		} catch (Exception e) {
			myMap.put("mess", "修改失败！");
		}
	}

	@Override
	public Map<String, Object> findAll(Account account, Integer currPage,
			Integer currSize) {
		if (currPage == null) {
			currPage = 1;
		}
		AccountDaoImpl adi = new AccountDaoImpl();
		adi.setCurrPage(currPage);
		adi.setCurrSize(currSize);
		return accountDaoImpl.findAll(account, adi);
	}

}
