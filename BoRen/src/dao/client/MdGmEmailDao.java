package dao.client;

import java.util.List;

import entity.GmEmail;

public interface MdGmEmailDao {
	//测试完添加 5-7 19:24
	/**
	 * @param gmEmail
	 * 改变gm
	 */
	void mdAdd(GmEmail gmEmail) throws Exception;
	
	
	/**
	 * @param gmEmail
	 * 添加gm
	 */
	void mdChange(GmEmail gmEmail) throws Exception;
	
	/**
	 * @param gmEmail
	 * @return 用户查询email
	 */
	List<GmEmail> mdQueryUserInfo(GmEmail gmEmail);
	
	/**
	 * @param gmEmail
	 * @return id查询
	 */
	GmEmail mdQueryById(GmEmail gmEmail);
}
