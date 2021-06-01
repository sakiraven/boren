package service.client.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdGmEmailDao;
import dao.client.MdUserInfoDao;
import dao.client.impl.MdGmEmailTypeDaoImpl;

import entity.CommentTwoLevel;
import entity.GmEmail;
import service.client.MsCommentTwoService;
import service.client.MsGmEmailService;

@Service
public class MsGmEmailServiceImpl implements MsGmEmailService {
	@Autowired
	private MdGmEmailDao mdGmEmailDaoImpl;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	@Autowired
	private MdGmEmailTypeDaoImpl mdGmEmailTypeDaoImpl; 
	//添加gm
	public int msAddGm(GmEmail gmEmail) {
		int result = 1;
		try {
			gmEmail.setEmailType(this.mdGmEmailTypeDaoImpl.getType(gmEmail.getEmailType_1()));
			gmEmail.setUserInfoByEmailSendId(this.mdUserInfoDaoImpl.mdQueryOne(gmEmail.getUserInfoByEmailSendId()));
			this.mdGmEmailDaoImpl.mdAdd(gmEmail);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	//用户查询gm
	public List<GmEmail> msQueryGm(GmEmail gmEmail) {
		return this.mdGmEmailDaoImpl.mdQueryUserInfo(gmEmail);
	}
	//更改阅读状态
	public List<GmEmail> msStatusGm(GmEmail gmEmail) {
		List<GmEmail> reLt =null;
		GmEmail getObj = this.mdGmEmailDaoImpl.mdQueryById(gmEmail);
		try {
			getObj.setEmailStatus(1);
			this.mdGmEmailDaoImpl.mdChange(getObj);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			reLt = this.mdGmEmailDaoImpl.mdQueryUserInfo(gmEmail);
		}
		return reLt;
	}

}
