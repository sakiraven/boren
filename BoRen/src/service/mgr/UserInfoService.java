package service.mgr;

import java.util.Date;
import java.util.Map;

import entity.UserInfo;

public interface UserInfoService {
	// 模糊查询(分页)
	Map<String, Object> findAll(String userName, Integer currPage,
			Integer currSize);

	// 修改用户
	void updateUserInfo(UserInfo userInfo);

	// 按ID查询
	UserInfo findUserInfo(Integer userId);

	// 按类型管理
	Map<String, Object> typeUser();

}
