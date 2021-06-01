package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.GmEmailService;
import entity.GmEmail;

@Controller
public class GmEmailController {
	@Autowired
	GmEmailService gmEmailServiceImpl;

	@RequestMapping("gmEmailAll.do")
	@ResponseBody
	public Object getGmEmailAll(Integer currPage, Integer typeId) {
		return gmEmailServiceImpl.getAll(currPage, 15, typeId);
	}

	@RequestMapping("delGmEmail.do")
	@ResponseBody
	public Object delGmEmail(GmEmail gmEmail) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", gmEmailServiceImpl.delGmEmail(gmEmail));
		return myMap;
	}

	@RequestMapping("addGmEmailAll.do")
	@ResponseBody
	public Object addGmEmail(String textInfo, Integer emailStatus,
			Integer emailType_1, Integer typeId, Integer sendToId,
			Integer sendId) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", gmEmailServiceImpl.addGmEmail(textInfo, emailStatus,
				emailType_1, typeId, sendToId, sendId));
		return myMap;
	}

	@RequestMapping("getGmEmail.do")
	@ResponseBody
	public Object getGmEmail(Integer emailId) {
		return gmEmailServiceImpl.getGmEmail(emailId);
	}

	@RequestMapping("updateGmEmail.do")
	@ResponseBody
	public Object updateGmEmail(Integer eid) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		gmEmailServiceImpl.updateGmEmail(eid);
		myMap.put("mess", "修改成功！");
		return myMap;
	}
}
