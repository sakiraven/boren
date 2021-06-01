package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.UserInfo;

import service.AccountService;
import service.CookBookService;

@Controller
public class AccountController {

	// 👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private AccountService accountService;

	// 👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆

	// 👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	@RequestMapping("clientLogin.do")
	@ResponseBody
	public Object clientLogin(Account account) {
		return this.accountService.clientLogin(account);
	}
	@RequestMapping("addAccount.do")
	@ResponseBody
	public Object addAccount(Account account,UserInfo userInfo) {
		return this.accountService.addAccount(account,userInfo);
	}
	@RequestMapping("checkAccount.do")
	@ResponseBody
	public Object checkAccount(Account account) {
		return this.accountService.checkAccount(account);
	}
	
	// 👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
