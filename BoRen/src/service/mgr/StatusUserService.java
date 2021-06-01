package service.mgr;

import entity.StatusUser;

public interface StatusUserService {

	// 封印解除
	void delStatusUser(Integer userId);

	// 添加封印
	void addStatusUser(Integer userId, Integer day);

	// 按ID查询
	StatusUser findStatusUser(Integer statusId);
}
