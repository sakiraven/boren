package dao.mgr.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CommonCURD;
import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.StatusUserDao;
import entity.StatusUser;

@Repository
public class StatusUserDaoImpl implements StatusUserDao {
	@Autowired
	CommonQueryDao commonQueryDao;
	@Autowired
	ICommonCURD commonCURD;

	@Override
	public void delStatusUser(StatusUser statusUser) {
		commonCURD.modifyObj(statusUser, commonCURD.DEL);
	}

	@Override
	public void addStatusUser(StatusUser statusUser) {
		commonCURD.modifyObj(statusUser, commonCURD.SAVE);
	}

	@Override
	public StatusUser findStatusUser(Integer statusId) {
		return (StatusUser) commonQueryDao
				.queryById(StatusUser.class, statusId);
	}

}
