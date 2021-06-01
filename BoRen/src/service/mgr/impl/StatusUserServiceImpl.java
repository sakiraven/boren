package service.mgr.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.StatusUserService;
import dao.mgr.StatusUserDao;
import dao.mgr.UserInfoDao;
import entity.StatusUser;
import entity.UserInfo;

@Service
public class StatusUserServiceImpl implements StatusUserService {
	@Autowired
	StatusUserDao statusUserDaoImpl;

	@Autowired
	UserInfoDao userInfoDaoImpl;

	@Override
	public void delStatusUser(Integer userId) {
		if (userId != null) {
			StatusUser statusUser = null;
			UserInfo userInfo = null;
			StatusUser statusUser1 = null;
			userInfo = userInfoDaoImpl.findUserInfo(userId);
			statusUser = userInfo.getStatusUser();
			if (statusUser.getStatusId() != 1) {
				statusUser1 = statusUserDaoImpl.findStatusUser(1);
				userInfo.setStatusUser(statusUser1);
				statusUserDaoImpl.delStatusUser(statusUser);
			}
		}
	}

	@Override
	public void addStatusUser(Integer userId, Integer day) {
		StatusUser statusUser = new StatusUser();
		UserInfo userInfo = null;
		if (userId != null && day != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DATE, day);
			Timestamp ts = Timestamp.valueOf(df.format(ca.getTime()));
			statusUser.setStatusTime(ts);
			statusUserDaoImpl.addStatusUser(statusUser);
			userInfo = userInfoDaoImpl.findUserInfo(userId);
			userInfo.setStatusUser(statusUser);
			userInfoDaoImpl.updateUserInfo(userInfo);
		}
	}

	@Override
	public StatusUser findStatusUser(Integer statusId) {
		return statusUserDaoImpl.findStatusUser(statusId);
	}
}