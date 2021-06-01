package service.mgr.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.GmEmailService;
import dao.mgr.GmEmailDao;
import dao.mgr.impl.GmEmailDaoImpl;
import entity.EmailType;
import entity.GmEmail;
import entity.UserInfo;

@Service
public class GmEmailServiceImpl implements GmEmailService {
	@Autowired
	GmEmailDao gmEmailDaoImpl;

	@Override
	public Map getGmEmail(Integer emailId) {
		return gmEmailDaoImpl.getGmEmail(emailId);
	}

	@Override
	public String delGmEmail(GmEmail gmEmail) {
		if (gmEmail.getEmailId() != null || !gmEmail.getEmailId().equals("")) {
			gmEmailDaoImpl.delGmEmail(gmEmail);
			return "删除成功！";
		}
		return "删除失败！";
	}

	@Override
	public String addGmEmail(String textInfo, Integer emailStatus,
			Integer emailType_1, Integer typeId, Integer sendToId,
			Integer sendId) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		if (emailStatus != null && (!textInfo.isEmpty() && textInfo != null)
				&& (typeId != null) && (sendId != null) && (sendToId != null)) {
			GmEmail gmEmail = new GmEmail();
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(sendId);// 发件人
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setUserId(sendToId);// 收件人
			EmailType emailType = new EmailType();
			emailType.setEmailTypeId(typeId);// 邮件类型
			gmEmail.setUserInfoByEmailSendId(userInfo);
			gmEmail.setUserInfoByEmailSendToId(userInfo1);
			gmEmail.setEmailType(emailType);
			gmEmail.setEmailText(textInfo);
			gmEmail.setEmailStatus(emailStatus);
			gmEmail.setEmailType_1(emailType_1);
			gmEmailDaoImpl.addGmEmail(gmEmail);
			return "发送成功！";
		}
		return "发送失败！";
	}

	@Override
	public Map getAll(Integer currPage, Integer currSize, Integer typeId) {
		if (currPage == null || currPage.equals("")) {
			currPage = 1;
		}
		GmEmailDaoImpl gmEmailDaoIpl = new GmEmailDaoImpl();
		gmEmailDaoIpl.setCurrSize(currSize);
		gmEmailDaoIpl.setCurrPage(currPage);
		GmEmail gmEmail = new GmEmail();
		EmailType type = new EmailType();
		type.setEmailTypeId(typeId);
		gmEmail.setEmailType(type);
		return gmEmailDaoImpl.getAll(gmEmailDaoIpl, gmEmail);
	}

	@Override
	public void updateGmEmail(Integer eid) {
		GmEmail gmEmail = new GmEmail();
		gmEmail.setEmailId(eid);
		gmEmailDaoImpl.updateGmEmail(gmEmail);

	}
}
