package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.PostTypeService;

import entity.PostType;

@Controller
public class PostTypeController {
	@Autowired
	PostTypeService postTypeServiceImpl;

	@RequestMapping("postTypeList.do")
	@ResponseBody
	public Object getPostTpyeAll() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("list", postTypeServiceImpl.getAll());
		return myMap;
	}
}
