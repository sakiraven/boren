package dao;

import java.util.List;

import entity.Account;
import entity.UserInfo;

public interface UserInfoDao {
	void sign(UserInfo userInfo) throws Exception;
	
	List<UserInfo> queryOneInfo(UserInfo userInfo);

	void addUserInfo(UserInfo userInfo) throws Exception;
	
	void updateB(UserInfo userInfo);
}
