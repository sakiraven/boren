package service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CookBookDao;
import dao.MessageDao;
import entity.Message;

@Service
public class MessageService {

	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	private Map<String, Object> reMap;
	@Autowired
	private MessageDao messageDao;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	
	/**
	 * @param message
	 * @return 查看消息
	 */
	public Object queryMessageByUserInfo(Message message) {
		reMap = new HashMap<String, Object>();
		try {
			this.messageDao.upDateStatus(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更改消息阅读状态异常");
		}
		reMap.put("messageList", this.messageDao.queryMessageByUserInfo(message));
		return reMap;
	}

	/**
	 * @param message
	 * @return 查看是否读取
	 */
	public Object queryMessageSize(Message message) {
		reMap = new HashMap<String, Object>();
		reMap.put("result", this.messageDao.queryMessageSize(message).size());
		return reMap;
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆

}
