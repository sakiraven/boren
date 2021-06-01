package dao.mgr;

import java.util.Map;

import dao.mgr.impl.GmEmailDaoImpl;
import entity.GmEmail;

public interface GmEmailDao {
	// 查询所有邮件
	Map getAll(GmEmailDaoImpl gmEmailDaoIpl, GmEmail gmEmail);

	// 按ID查询
	Map getGmEmail(Integer emailId);

	// 删除邮件
	void delGmEmail(GmEmail gmEmail);

	// 添加邮件
	void addGmEmail(GmEmail gmEmail);
	
	//修改邮件状态
	void updateGmEmail(GmEmail gmEmail);

}
