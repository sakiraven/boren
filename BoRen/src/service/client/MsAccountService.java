package service.client;

import entity.Account;
import entity.UserInfo;

public interface MsAccountService {
	/**
	 * @param account
	 * @return 登录
	 */
	Account msLogin(Account account);

	/**
	 * @param account
	 *            注册账号部分
	 */
	int msAdd(Account account, UserInfo userInfo);
}
