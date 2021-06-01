package service.mgr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.AdminService;
import dao.mgr.impl.AdminDaoImpl;
import entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDaoImpl adminDaoImpl;

	@Override
	public List<Admin> getAll() {
		return adminDaoImpl.getAll();
	}

	@Override
	public Admin getAdmin(int aid) {
		return adminDaoImpl.getAdmin(aid);
	}

	@Override
	public void addAdmin(Admin admin) {
		adminDaoImpl.addAdmin(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDaoImpl.updateAdmin(admin);
	}

}
