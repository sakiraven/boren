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
	//πππππππππππ**ε¨ε±**πππππππππππ
	@Autowired
	private UserInfoService userInfoService;
	//πππππππππππ**ε¨ε±**πππππππππππ
	
	//πππππππππππ**ζΉζ³**ππππππππππ
	/**
	 * @return η­Ύε°
	 */
	@RequestMapping("sign.do")
	@ResponseBody
	public Object sign(UserInfo userInfo){
		return this.userInfoService.sign(userInfo);
	}
	//πππππππππππ**ζΉζ³**πππππππππππ
}
