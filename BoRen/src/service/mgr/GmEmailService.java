package service.mgr;

import java.util.Map;

import dao.mgr.impl.GmEmailDaoImpl;
import entity.GmEmail;

public interface GmEmailService {
	// 查询所有邮件
	Map getAll(Integer currPage, Integer currSize, Integer typeId);

	// 按ID查询
	Map getGmEmail(Integer emailId);

	// 删除邮件
	String delGmEmail(GmEmail gmEmail);

	// 添加邮件
	String addGmEmail(String textInfo, Integer emailStatus,
			Integer emailType_1, Integer typeId, Integer sendToId,
			Integer sendId);

	// 修改邮件阅读状态
	void updateGmEmail(Integer eid);

}
