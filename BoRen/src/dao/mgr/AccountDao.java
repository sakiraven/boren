package dao.mgr;

import java.util.List;
import java.util.Map;

import dao.mgr.impl.AccountDaoImpl;
import entity.Account;

public interface AccountDao {
	// 查询所有账号
	List<Account> getAll();

	// 按ID查找单个账号
	Account getAccount(int aid);

	// 修改账号
	void updateAccount(Account account);

	// 模糊查询(分页)
	Map<String, Object> findAll(Account account, AccountDaoImpl accountDao);

}
