package dao;

import java.util.List;

import entity.Account;

public interface AccountDao {

	List<Account> clientLogin(Account account);

	void addAccount(Account account) throws Exception;

	List<Account> queryOne(Account account);
	
	List<Account> checkAccount(Account account);
	
}
