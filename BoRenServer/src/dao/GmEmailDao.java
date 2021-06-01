package dao;

import java.util.List;

import entity.GmEmail;
import entity.Message;
import entity.UserInfo;

public interface GmEmailDao {

	List<GmEmail> queryGm(UserInfo userInfo);

	void addGm(GmEmail gmEmail) throws Exception;

}
