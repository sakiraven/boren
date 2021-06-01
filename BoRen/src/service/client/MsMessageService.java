package service.client;

import java.util.List;

import entity.Account;
import entity.Message;
import entity.UserInfo;

public interface MsMessageService {
	/**
	 * @param message
	 * 添加
	 */
	void msAddMessage(Message message);
	/**
	 * @param message
	 * @return 查询用户消息
	 */
	List<Message> msQueryUserInfo(Message message);
	
	/**
	 * @param message
	 * 更改阅读状态
	 */
	List<Message> msChangeStatus(Message message);
	
	/**
	 * @param message
	 * 删除消息
	 */
	int msDel(Account account);
}
