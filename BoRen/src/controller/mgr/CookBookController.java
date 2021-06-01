package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.mgr.CookBookService;
import entity.CookBook;

@Controller
public class CookBookController {
	@Autowired
	CookBookService cookBookServiceImpl;

	@RequestMapping("cookBookAll.do")
	@ResponseBody
	public Object getCookBookAll() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("list", cookBookServiceImpl.getAll());
		return myMap;
	}

	@RequestMapping("delCookBook.do")
	@ResponseBody
	public Object delCookBook(CookBook cookbook) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", cookBookServiceImpl.delCookBook(cookbook));
		return myMap;
	}

	@RequestMapping("addCookBook.do")
	@ResponseBody
	public Object addCookBook(CookBook cookbook) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", cookBookServiceImpl.saveCookBook(cookbook));
		return myMap;
	}
}
