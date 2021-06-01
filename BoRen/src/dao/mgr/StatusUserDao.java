package dao.mgr;

import entity.StatusUser;

public interface StatusUserDao {
	// 封印解除
	void delStatusUser(StatusUser statusUser);

	// 添加封印
	void addStatusUser(StatusUser statusUser);

	// 按ID查询
	StatusUser findStatusUser(Integer statusId);
}
