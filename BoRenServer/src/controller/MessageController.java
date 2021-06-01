package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Message;

import service.MessageService;

@Controller
public class MessageController {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private MessageService messageService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	/**
	 * @param message
	 * @return 显示消息
	 */
	@RequestMapping("queryMessageByUserInfo.do")
	@ResponseBody
	public Object queryMessageByUserInfo(Message message) {
		return this.messageService.queryMessageByUserInfo(message);
	}
	
	/**
	 * @param message
	 * @return 未读状态
	 */
	@RequestMapping("queryMessageSize.do")
	@ResponseBody
	public Object queryMessageSize(Message message) {
		return this.messageService.queryMessageSize(message);
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
