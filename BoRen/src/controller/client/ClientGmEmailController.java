package controller.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.GmEmail;

import service.client.MsGmEmailService;

@Controller
public class ClientGmEmailController {
	Map<String, Object> reMap;
	@Autowired
	private MsGmEmailService msGmEmailService;
	/**
	 * @param gmEmail
	 * @return 添加gm
	 */
	@RequestMapping("addGm.do")
	@ResponseBody
	public Object clientAddGm(GmEmail gmEmail){
		reMap = new HashMap<String, Object>();
		int result = this.msGmEmailService.msAddGm(gmEmail);
		if(result>0)
			reMap.put("result", "创建成功");
		else
			reMap.put("result", "发送异常请联系管理员qq714158220");
		return this.reMap;
	}
	/**
	 * @param gmEmail
	 * @return 查询
	 */
	@RequestMapping("queryGm.do")
	@ResponseBody
	public Object clientQueryGm(GmEmail gmEmail){
		this.reMap = new HashMap<String, Object>();
		List<GmEmail> getlt = this.msGmEmailService.msQueryGm(gmEmail);
		this.reMap.put("gmList", getlt);
		return this.reMap;
	}
	
	/**
	 * @param gmEmail
	 * @return 更改阅读状态
	 */
	@RequestMapping("changeGmStatus.do")
	@ResponseBody
	public Object clientChangeGmStatus(GmEmail gmEmail){
		this.reMap = new HashMap<String, Object>();
		List<GmEmail> getlt = this.msGmEmailService.msStatusGm(gmEmail);
		this.reMap.put("result", getlt);
		return this.reMap;
	}
}
