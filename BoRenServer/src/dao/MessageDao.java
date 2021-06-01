package dao;

import java.util.List;
import java.util.Map;

import entity.Message;

public interface MessageDao {

	List<Message> queryMessageByUserInfo(Message message);

	List<Message> queryMessageSize(Message message);

	void upDateStatus(Message message) throws Exception;

	void addMessage(Message message);

}
