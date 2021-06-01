package controller.mgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.impl.AdminServiceImpl;
import entity.Admin;

@Controller
public class AdminController {
	@Autowired
	AdminServiceImpl adminServiceImpl;

	// 获取所有等级
	@RequestMapping("adminAll.do")
	@ResponseBody
	public Object getAll() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		List myList = null;
		myList = adminServiceImpl.getAll();
		myMap.put("allAdmin", myList);
		return myMap;
	}
}
