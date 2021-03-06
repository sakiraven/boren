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

	// πππππππππππ**ε¨ε±**πππππππππππ
	private Map<String, Object> reMap;
	@Autowired
	private MessageDao messageDao;

	// πππππππππππ**ε¨ε±**πππππππππππ

	// πππππππππππ**ζΉζ³**ππππππππππ
	
	/**
	 * @param message
	 * @return ζ₯ηζΆζ―
	 */
	public Object queryMessageByUserInfo(Message message) {
		reMap = new HashMap<String, Object>();
		try {
			this.messageDao.upDateStatus(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ζ΄ζΉζΆζ―ιθ―»ηΆζεΌεΈΈ");
		}
		reMap.put("messageList", this.messageDao.queryMessageByUserInfo(message));
		return reMap;
	}

	/**
	 * @param message
	 * @return ζ₯ηζ―ε¦θ―»ε
	 */
	public Object queryMessageSize(Message message) {
		reMap = new HashMap<String, Object>();
		reMap.put("result", this.messageDao.queryMessageSize(message).size());
		return reMap;
	}
	// πππππππππππ**ζΉζ³**πππππππππππ

}
