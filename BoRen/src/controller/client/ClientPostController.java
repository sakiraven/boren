package controller.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Comment;
import entity.EntityUtil;
import entity.Message;
import entity.Post;
import entity.PostType;

import service.client.MsPostService;
import service.client.impl.MsPostServiceImpl;
import util.KeyWordFileter;

@Controller
public class ClientPostController {
	Map<String, Object> reMap;
	@Autowired
	MsPostService msPostServiceImpl;
	/**
	 * @return 查看所有帖子
	 */
	@RequestMapping("postQueryAll.do")
	@ResponseBody
	public Object postQueryAll(){
		reMap=new HashMap<String, Object>();
		reMap.put("postList", this.msPostServiceImpl.msQueryAll());
		return reMap;
	}
	/**
	 * @return 查看所有帖子动态查询
	 */
	@RequestMapping("postQueryAllLike.do")
	@ResponseBody
	public Object postQueryAllLike(Post post,int currentPage) {
		reMap=new HashMap<String, Object>();
		return this.msPostServiceImpl.msQueryAllLike(post, currentPage);
	}
	
	/**
	 * @param post
	 * @return 创建帖子
	 */
	@RequestMapping("postAdd.do")
	@ResponseBody
	public Object postAdd (Post post){
		reMap=new HashMap<String, Object>();
		int result = this.msPostServiceImpl.msAdd(post);
		if(result==1){
			reMap.put("result", "创建成功");
		}else if(result==-200){
			reMap.put("result", "标题或正文有敏感词 请整理后发送帖子");
		}else{
			reMap.put("result", "创建异常 请联系管理员714158220");
		}
		return reMap;
	}
	/**
	 * @param post
	 * @return id查询
	 */
	@RequestMapping("postQueryOneById.do")
	@ResponseBody
	public Object postQueryOneById(Post post,int fansId){
		reMap=new HashMap<String, Object>();
		reMap.put("postList", this.msPostServiceImpl.msQueryOneById(post,fansId));
		return reMap;
	}
	
	/**
	 * @param post
	 * @return 点赞
	 */
	@RequestMapping("postLove.do")
	@ResponseBody
	public Object postLove(Post post,int sendToId,int sendId){
		this.reMap = new HashMap<String, Object>();
		int result = this.msPostServiceImpl.msLove(post,sendToId,sendId);
		if(result>0){
			this.reMap.put("result", "点赞成功");
		}else{
			this.reMap.put("result", "点赞失败");
		}
		return this.reMap;
	}
	
	/**
	 * @param postType
	 * @return 帖子类型查看
	 */
	@RequestMapping("postTypeQuery.do")
	@ResponseBody
	public Object postTypeQuery(PostType postType,int currentPage,String postTitle){
		return this.msPostServiceImpl.msQueryType(postType,currentPage,postTitle);
	}
	
	/**
	 * @param postType
	 * @return 热度查询
	 */
	@RequestMapping("postLoveQuery.do")
	@ResponseBody
	public Object postLoveQuery(PostType postType){
		this.reMap = new HashMap<String, Object>();
		this.reMap.put("postList", this.msPostServiceImpl.msQueryLoveType(postType));
		return this.reMap;
	}
	/**
	 * @param postId
	 * @return 投币
	 */
	@RequestMapping("postTouB.do")
	@ResponseBody
	public Object postTouB(int postId,int sendId,int sendToId){
		int result = this.msPostServiceImpl.msTouB(postId,sendId,sendToId);
		this.reMap.put("B", result);
		return this.reMap;
	}
}






