package controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.impl.MsCollectPostServiceImpl;

import dao.client.impl.MdCollectPostDaoImpl;

@Controller
public class ClientCollectPostController {
	@Autowired
	private MsCollectPostServiceImpl collectPostServiceImpl;
	
	/**
	 * @param postId
	 * @param acctId
	 * @return 添加收藏
	 */
	@RequestMapping("addCollPost.do")
	@ResponseBody
	public Object addCollPost(int postId,int acctId){
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("result", this.collectPostServiceImpl.addCollPost(postId, acctId));
		return reMap;
	}
}
