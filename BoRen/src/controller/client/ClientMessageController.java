package controller.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.MsMessageService;

import entity.Account;
import entity.EntityUtil;
import entity.Message;
import entity.UserInfo;

@Controller
public class ClientMessageController {
	private Map<String, Object> reMap;
	@Autowired
	private MsMessageService msMessageService;
	/**
	 * @param message
	 * @return 查询message数量
	 */
	@RequestMapping("queryMessageSize.do")
	@ResponseBody
	public Object clientQueryMessageSize(Message message){
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("result", this.msMessageService.msQueryUserInfo(message).size());
		return reMap;
	}
	/**
	 * @param message
	 * @return 用户查询
	 */
	@RequestMapping("queryMessageByUserInfo.do")
	@ResponseBody
	public Object clientQueryMessageByUserInfo(Message message){
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("messageList", this.utilEntity(this.msMessageService.msChangeStatus(message)));
		return this.reMap;
	}
	
	/**
	 * @param message
	 * @return 消息删除
	 */
	@RequestMapping("delMessage.do")
	@ResponseBody
	public Object clientDelMessage(Account account){
		this.reMap = new HashMap<String, Object>();
		int result = this.msMessageService.msDel(account);
		if(result ==1)
			this.reMap.put("result", "删除成功");
		else
			this.reMap.put("result", "删除异常，请联系管理员qq714158220");
		return reMap;
	}
	//封装
	private List<EntityUtil> utilEntity(List<Message> getlt){
		List<EntityUtil> reLt = new ArrayList<EntityUtil>();
		for (Message msg : getlt) {
			EntityUtil enl = new EntityUtil();
			enl.setSendName(msg.getUserInfoByMsgSendId().getUserName());
			enl.setSendToName(msg.getUserInfoByMsgSendToId().getUserName());
			enl.setMessageType(msg.getMsgType());
			enl.setPostId(msg.getPost().getPostId());
			enl.setPostTitle(msg.getPost().getPostTitle());
			if(msg.getComment()!=null)
				enl.setCmmtFloor(msg.getComment().getCmmtFloor());
			reLt.add(enl);
		}
		return reLt;
	}
}
