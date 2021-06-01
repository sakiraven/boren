package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.ShopList;

import service.mgr.ShopListService;

@Controller
public class ShopListController {
	@Autowired
	ShopListService shopListServiceImpl;

	@RequestMapping("shopListAll.do")
	@ResponseBody
	public Object getShopListAll() {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("list", shopListServiceImpl.getAll());
		return myMap;
	}

	@RequestMapping("delShopList.do")
	@ResponseBody
	public Object delShopList(ShopList sl) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", shopListServiceImpl.delShopList(sl));
		return myMap;
	}

	@RequestMapping("addShopList.do")
	@ResponseBody
	public Object addShopList(ShopList sl) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("mess", shopListServiceImpl.addShopList(sl));
		return myMap;
	}
}
