package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.CollectPost;
import entity.Comment;
import entity.Post;
import entity.UserInfo;

import service.AccountService;
import service.CollectPostService;
import service.CommentService;
import service.CookBookService;

@Controller
public class CollectPostController {

	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private CollectPostService collectPostService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	@RequestMapping("addCollPost.do")
	@ResponseBody
	public Object commentQueryByCmmtId(CollectPost cp) {
		return this.collectPostService.addColl(cp);
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
