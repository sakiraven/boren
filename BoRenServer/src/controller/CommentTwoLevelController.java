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
	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	@Autowired
	private CommentTwoLevelService commentTwoLevelService;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
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
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ
}
