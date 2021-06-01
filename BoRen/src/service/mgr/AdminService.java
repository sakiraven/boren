package service.mgr;

import java.util.List;

import entity.Admin;

public interface AdminService {
	// 查询所有等级
	List<Admin> getAll();

	// 按ID查询
	Admin getAdmin(int aid);

	// 添加等级
	void addAdmin(Admin admin);

	// 修改等级
	void updateAdmin(Admin admin);
}
