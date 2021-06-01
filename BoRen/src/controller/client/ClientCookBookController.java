package controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.MsCookBookService;

@Controller
public class ClientCookBookController {
	private Map<String, Object> reMap;
	@Autowired
	private MsCookBookService msCookBookServiceImpl;
	/**
	 * @return 查看所有菜单
	 */
	@RequestMapping("queryCookBook.do")
	@ResponseBody
	public Object queryCookBook(){
		this.reMap = new HashMap<String, Object>();
		System.out.println( this.msCookBookServiceImpl.msQueryAll().size());
		this.reMap.put("cookBookList", this.msCookBookServiceImpl.msQueryAll());
		return this.reMap;
	}
}
