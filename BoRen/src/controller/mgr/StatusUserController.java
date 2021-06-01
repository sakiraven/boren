package controller.mgr;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.StatusUserService;
import entity.StatusUser;

@Controller
public class StatusUserController {
	@Autowired
	StatusUserService statusUserServiceImpl;

	@RequestMapping("addStatusUser.do")
	@ResponseBody
	public void addStatusUser(Integer userId, Integer day) {
		statusUserServiceImpl.addStatusUser(userId, day);
	}

	@RequestMapping("delStatusUser.do")
	@ResponseBody
	public void delStatusUser(Integer userId) {
		statusUserServiceImpl.delStatusUser(userId);
	}
}
