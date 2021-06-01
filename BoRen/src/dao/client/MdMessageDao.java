package dao.client;

import java.util.List;

import com.sun.mail.handlers.message_rfc822;

import entity.Account;
import entity.Message;
import entity.UserInfo;

public interface MdMessageDao {
	/**
	 * @param message
	 * 添加
	 */
	void mdAddMessage(Message message);
	/**
	 * @param message
	 * @return 查询用户消息
	 */
	List<Message> mdQueryUserInfo(Message message);
	
	/**
	 * @param message
	 * 更改阅读状态
	 */
	void mdChange(List<Message> messLt);
	
	/**
	 * @return 查询所有
	 */
	List<Message> mdQueryMessageAll(Account account);
	
	/**
	 * @param message
	 * 删除所有消息
	 */
	void mdDel(List<Message> msgLt) throws Exception;
}
