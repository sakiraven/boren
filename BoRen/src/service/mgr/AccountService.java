package service.mgr;

import java.util.List;
import java.util.Map;

import dao.mgr.impl.AccountDaoImpl;
import entity.Account;

public interface AccountService {
	// 查询所有账号
	List<Account> getAll();

	// 按ID查找单个账号
	Account getAccount(int aid);

	// 修改账号等级
	void updateAccount(Integer userInfoId, Integer adminId);

	// 模糊查询(分页)
	Map<String, Object> findAll(Account account, Integer currPage,
			Integer currSize);
}
