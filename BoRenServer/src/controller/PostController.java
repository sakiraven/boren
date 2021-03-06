package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Post;

import service.PostService;
@Controller
public class PostController {
	//đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	@Autowired
	private PostService postService;
	//đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	
	//đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	@RequestMapping("postLoveQuery.do")
	@ResponseBody
	public Object postLoveQuery(Post post){
		return this.postService.postLoveQuery(post);
	}
	
	@RequestMapping("postTypeQuery.do")
	@ResponseBody
	public Object postTypeQuery(Post post){
		return this.postService.postTypeQuery(post);
	}
	
	@RequestMapping("postAdd.do")
	@ResponseBody
	public Object postAdd(Post post){
		return this.postService.postAdd(post);
	}
	
	@RequestMapping("postQueryOneById.do")
	@ResponseBody
	public Object postQueryOneById(Post post){
		return this.postService.postQueryOneById(post);
	}
	@RequestMapping("postTouB.do")
	@ResponseBody
	public Object postTouB(Post post){
		return this.postService.postTouB(post);
	}
	@RequestMapping("postLove.do")
	@ResponseBody
	public Object postLove(Post post){
		return this.postService.postLove(post);
	}
	
	//đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ
}
