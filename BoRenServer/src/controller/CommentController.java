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

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	@Autowired
	private CommentService commentService;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
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
	
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ
}
