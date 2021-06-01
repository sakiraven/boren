package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.UserInfo;

import service.PostService;
import service.UserInfoService;
@Controller
public class UserInfoController {
	//👇👇👇👇👇👇👇👇👇👇👇**全局**👇👇👇👇👇👇👇👇👇👇👇
	@Autowired
	private UserInfoService userInfoService;
	//👆👆👆👆👆👆👆👆👆👆👆**全局**👆👆👆👆👆👆👆👆👆👆👆
	
	//👇👇👇👇👇👇👇👇👇👇👇**方法**👇👇👇👇👇👇👇👇👇👇
	/**
	 * @return 签到
	 */
	@RequestMapping("sign.do")
	@ResponseBody
	public Object sign(UserInfo userInfo){
		return this.userInfoService.sign(userInfo);
	}
	//👆👆👆👆👆👆👆👆👆👆👆**方法**👆👆👆👆👆👆👆👆👆👆👆
}
