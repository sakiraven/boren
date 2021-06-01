package service.client;

import entity.ShopList;
import entity.UserInfo;

public interface MsUserInfoService {
	/**
	 * @param userInfo
	 * @return 查询单个用户
	 */
	UserInfo msQueryOne(UserInfo userInfo);

	/**
	 * @param userInfo
	 *            充值
	 */
	int msReChange(UserInfo userInfo);

	/**
	 * @param userInfo
	 *            消费
	 */
	int msSpend(UserInfo userInfo, ShopList shopList);

	/**
	 * @param userInfo
	 * @return 签到
	 */
	public int msSign(UserInfo userInfo);
}
