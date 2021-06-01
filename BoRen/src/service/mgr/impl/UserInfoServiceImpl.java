package service.mgr.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.UserInfoService;
import dao.mgr.AdminDao;
import dao.mgr.UserInfoDao;
import dao.mgr.impl.UserInfoDaoImpl;
import entity.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDao userInfoDaoImpl;
	@Autowired
	AdminDao adminDaoImpl;

	@Override
	public synchronized Map<String, Object> findAll(String userName,
			Integer currPage, Integer currSize) {
		UserInfo userInfo = null;
		if (userName != null && !userName.equals("")) {
			userInfo = new UserInfo();
			userInfo.setUserName(userName);
		}
		if (currPage == null) {
			currPage = 1;
		}
		UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
		userInfoDao.setCurrPage(currPage);
		userInfoDao.setCurrSize(currSize);
		Map map = userInfoDaoImpl.findAll(userInfo, userInfoDao);
		return map;
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoDaoImpl.updateUserInfo(userInfo);

	}

	@Override
	public UserInfo findUserInfo(Integer userId) {
		return userInfoDaoImpl.findUserInfo(userId);
	}

	@Override
	public Map<String, Object> typeUser() {
		Date date = new Date();
		Map map = new HashMap<String, Object>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Object[] array = new Object[3];
		Calendar calender = Calendar.getInstance();
		/********** 今年 *****************/
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		Timestamp ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("Start", ts);
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		calender.add(Calendar.YEAR, +1);
		ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("End", ts);
		array[2] = map;
		/************ 去年 *******************/
		map = new HashMap<String, Object>();
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		calender.add(Calendar.YEAR, -1);
		ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("Start", ts);
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("End", ts);
		array[1] = map;
		/************ 前年 *******************/
		map = new HashMap<String, Object>();
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		calender.add(Calendar.YEAR, -2);
		ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("Start", ts);
		calender.setTime(date);
		calender.set(Calendar.DAY_OF_YEAR, 1);
		calender.add(Calendar.YEAR, -1);
		ts = Timestamp.valueOf(df.format(calender.getTime()));
		map.put("End", ts);
		array[0] = map;
		return userInfoDaoImpl.typeUser(array);
	}
}
