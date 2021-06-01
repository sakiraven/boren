package controller.mgr;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userInfoServiceImpl;

	// 获取所有账号
	@RequestMapping("allUserInfo.do")
	@ResponseBody
	public Object getAllAccount(String userName, Integer currPage) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap = userInfoServiceImpl.findAll(userName, currPage, 18);
		return myMap;
	}

	/*// 类别账号
	@RequestMapping("allTypeUser.do")
	@ResponseBody
	public Object getTypeUserInfo() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap = userInfoServiceImpl.typeUser();
		System.out.println(myMap);
		return myMap;
	}*/
}
