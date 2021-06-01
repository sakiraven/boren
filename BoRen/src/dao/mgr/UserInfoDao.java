package dao.mgr;

import java.util.Map;

import dao.mgr.impl.UserInfoDaoImpl;
import entity.UserInfo;

public interface UserInfoDao {
	// 模糊查询(分页)
	Map<String, Object> findAll(UserInfo userInfo, UserInfoDaoImpl userInfoDao);

	// 修改用户
	void updateUserInfo(UserInfo userInfo);

	// 按ID查询
	UserInfo findUserInfo(Integer userId);

	// 按类型管理
	Map<String, Object> typeUser(Object[] array);
}
