package dao.client;

import entity.UserInfo;
import entity.Vip;

public interface MdVipDao {
	/**
	 * @param userInfo
	 *            更改vip表
	 */
	void mdChange(Vip vip);

	/**
	 * @param userInfo
	 *            插入vip表
	 */
	void mdSave(Vip vip);

	/**
	 * @param userInfo
	 * @return 查看单个用户
	 */
	Vip mdQueryOne(UserInfo userInfo);
}
