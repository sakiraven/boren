package service.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sun.mail.handlers.message_rfc822;

import service.client.MsMessageService;

import dao.client.MdMessageDao;
import entity.Account;
import entity.Message;
import entity.UserInfo;

@Service
public class MsMessageServiceImpl implements MsMessageService {
	@Autowired
	private MdMessageDao mdMessageDaoImpl;

	public void msAddMessage(Message message) {
		this.mdMessageDaoImpl.mdAddMessage(message);
	}

	public List<Message> msQueryUserInfo(Message message) {
		return this.mdMessageDaoImpl.mdQueryUserInfo(message);
	}

	public List<Message> msChangeStatus(Message message) {
		List<Message> getLt = this.mdMessageDaoImpl.mdQueryUserInfo(message);
		this.mdMessageDaoImpl.mdChange(getLt);
		List<Message> reLt = this.mdMessageDaoImpl.mdQueryMessageAll(message.getUserInfoByMsgSendToId().getAccount());
		return reLt;
	}

	public int msDel(Account account) {
		int result = 1;
		try {
			List<Message> getLt = this.mdMessageDaoImpl.mdQueryMessageAll(account);
			this.mdMessageDaoImpl.mdDel(getLt);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

}
