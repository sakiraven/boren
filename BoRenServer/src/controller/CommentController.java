package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.Comment;
import entity.UserInfo;

import service.AccountService;
import service.CommentService;
import service.CookBookService;

@Controller
public class CommentController {

	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private CommentService commentService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	@RequestMapping("commentQueryByCmmtId.do")
	@ResponseBody
	public Object commentQueryByCmmtId(Comment comment) {
		return this.commentService.commentQueryByCmmtId(comment);
	}
	
	@RequestMapping("commentAdd.do")
	@ResponseBody
	public Object commentAdd(Comment comment) {
		return this.commentService.commentAdd(comment);
	}
	
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
