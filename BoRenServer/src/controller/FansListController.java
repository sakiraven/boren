package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.FansList;
import entity.GmEmail;
import entity.Message;
import entity.UserInfo;

import service.AccountService;
import service.CookBookService;
import service.FansListService;
import service.GmEmailService;

@Controller
public class FansListController {

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	@Autowired
	private FansListService fansListService;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	@RequestMapping("guanZhu.do")
	@ResponseBody
	public Object guanZhu(FansList fansList) {
		return this.fansListService.guanZhu(fansList);
	}
	
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ
}
