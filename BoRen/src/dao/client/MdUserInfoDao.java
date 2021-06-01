package dao.client;

import entity.UserInfo;

public interface MdUserInfoDao {
	/**
	 * @param userInfo
	 *            插入用户信息
	 */
	void mdAdd(UserInfo userInfo) throws Exception;

	/**
	 * @param userInfo
	 *            更改用户信息
	 */
	void mdChange(UserInfo userInfo) throws Exception;

	/**
	 * @param userInfo
	 * @return 查询单个用户信息
	 */
	UserInfo mdQueryOne(UserInfo userInfo);
}
