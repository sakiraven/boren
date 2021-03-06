package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CookBookService;

@Controller
public class CookBookController {

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	@Autowired
	private CookBookService cookBookService;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	@RequestMapping("queryCookBook.do")
	@ResponseBody
	public Object queryCookBook() {
		return this.cookBookService.queryCookBook();
	}
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ
}
