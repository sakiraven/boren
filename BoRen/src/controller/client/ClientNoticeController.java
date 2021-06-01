package controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.MsNoticeService;

@Controller
public class ClientNoticeController {
	private Map<String, Object> reMap;
	@Autowired
	private MsNoticeService msNoticeServiceImpl;
	@RequestMapping("queryNotice.do")
	@ResponseBody
	public Object queryNotice(){
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("noticeList", this.msNoticeServiceImpl.msQueryOne());
		return this.reMap;
	}
}
