package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.PostService;
import dao.mgr.impl.PostDaoImpl;
import entity.Post;

@Controller
public class PostController {
	@Autowired
	PostService postServiceImpl;

	@RequestMapping("postList.do")
	@ResponseBody
	public Object getPostAll(Integer currPage, Integer postTypeId) {
		Map myMap = postServiceImpl.getAll(currPage, postTypeId);
		System.out.println(myMap);
		return myMap;
	}

	@RequestMapping("delPost.do")
	@ResponseBody
	public Object delPost(Post post) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", postServiceImpl.delPost(post));
		return myMap;
	}
}
