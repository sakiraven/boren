package controller.mgr;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.impl.AccountServiceImpl;

import dao.CommonQueryDao;
import dao.mgr.impl.AccountDaoImpl;
import entity.Account;
import entity.UserInfo;

@Controller
public class AccountController {
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@RequestMapping("updateAccount.do")
	@ResponseBody
	public Object getAllAccount(Integer userInfoId, Integer adminId) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		accountServiceImpl.updateAccount(userInfoId, adminId);
		return myMap;
	}
}
