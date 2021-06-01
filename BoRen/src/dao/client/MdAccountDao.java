package dao.client;

import entity.Account;

public interface MdAccountDao {
	/**
	 * @param account
	 * @return 登录
	 */
	Account mdLogin(Account account);

	/**
	 * @param account
	 *            注册账号部分 1/2
	 */
	void mdAdd(Account account) throws Exception;

}
