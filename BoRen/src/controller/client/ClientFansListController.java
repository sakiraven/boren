package controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.impl.MsFansListServiceImpl;

@Controller
public class ClientFansListController {
	@Autowired
	private MsFansListServiceImpl msFansListServiceImpl;
	@RequestMapping("guanZhu.do")
	@ResponseBody
	public Object guanZhu(int guanZhuId,int fenSiId){
		Map<String, Object> reMap = new HashMap<String, Object>();
		this.msFansListServiceImpl.add(guanZhuId, fenSiId);
		reMap.put("result", "关注成功");
		return reMap;
	}
}
