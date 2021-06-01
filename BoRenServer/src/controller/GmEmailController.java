package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.GmEmail;
import entity.Message;
import entity.UserInfo;

import service.AccountService;
import service.CookBookService;
import service.GmEmailService;

@Controller
public class GmEmailController {

	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private GmEmailService gmEmailService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	@RequestMapping("queryGm.do")
	@ResponseBody
	public Object clientLogin(UserInfo userInfo) {
		return this.gmEmailService.queryGm(userInfo);
	}
	
	@RequestMapping("addGm.do")
	@ResponseBody
	public Object addGm(GmEmail gmEmail) {
		return this.gmEmailService.addGm(gmEmail);
	}
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
