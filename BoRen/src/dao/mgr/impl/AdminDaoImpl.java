package dao.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.AdminDao;
import entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	CommonQueryDao commonQueryDao;
	@Autowired
	ICommonCURD commonCURD;

	@Override
	public List<Admin> getAll() {
		List<Admin> list = commonQueryDao.queryAll(Admin.class);
		List<Admin> list1 = new ArrayList<Admin>();
		for (Admin admin : list) {
			Admin admin1 = new Admin();
			admin1.setAdminId(admin.getAdminId());
			admin1.setAdminName(admin.getAdminName());
			list1.add(admin1);
		}
		return list1;
	}

	@Override
	public Admin getAdmin(int aid) {
		return (Admin) commonQueryDao.queryById(Admin.class, aid);
	}

	@Override
	public void addAdmin(Admin admin) {
		commonCURD.modifyObj(admin, commonCURD.SAVE);
	}

	@Override
	public void updateAdmin(Admin admin) {
		commonCURD.modifyObj(admin, commonCURD.UPDATE);
	}

}
