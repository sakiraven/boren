package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Message;

import service.MessageService;

@Controller
public class MessageController {
	// πππππππππππ**ε¨ε±**πππππππππππ
	@Autowired
	private MessageService messageService;

	// πππππππππππ**ε¨ε±**πππππππππππ

	// πππππππππππ**ζΉζ³**ππππππππππ
	/**
	 * @param message
	 * @return ζΎη€ΊζΆζ―
	 */
	@RequestMapping("queryMessageByUserInfo.do")
	@ResponseBody
	public Object queryMessageByUserInfo(Message message) {
		return this.messageService.queryMessageByUserInfo(message);
	}
	
	/**
	 * @param message
	 * @return ζͺθ―»ηΆζ
	 */
	@RequestMapping("queryMessageSize.do")
	@ResponseBody
	public Object queryMessageSize(Message message) {
		return this.messageService.queryMessageSize(message);
	}
	// πππππππππππ**ζΉζ³**πππππππππππ
}
