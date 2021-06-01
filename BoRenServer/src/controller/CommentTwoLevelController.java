package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.CommentTwoLevel;
import entity.Message;

import service.CommentTwoLevelService;
import service.MessageService;

@Controller
public class CommentTwoLevelController {
	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private CommentTwoLevelService commentTwoLevelService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	@RequestMapping("queryCommentTwoLevel.do")
	@ResponseBody
	public Object queryCommentTwoLevel(CommentTwoLevel commentTwoLevel) {
		return this.commentTwoLevelService.queryCommentTwoLevel(commentTwoLevel);
	}
	@RequestMapping("addCommentTwoLevel.do")
	@ResponseBody
	public Object addCommentTwoLevel(CommentTwoLevel commentTwoLevel) {
		return this.commentTwoLevelService.addCommentTwoLevel(commentTwoLevel);
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
