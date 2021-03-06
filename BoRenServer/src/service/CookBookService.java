package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CookBookDao;

import entity.CookBook;

@Service
public class CookBookService {
	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ
	private Map<String, Object> reMap;
	@Autowired
	private CookBookDao cookBookDao;

	// đđđđđđđđđđđ**ĺ¨ĺą**đđđđđđđđđđđ

	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđ
	public Map queryCookBook() {
		reMap = new HashMap<String, Object>();
		reMap.put("cookBookList", cookBookDao.queryCookBook());
		return reMap;
	}
	// đđđđđđđđđđđ**ćšćł**đđđđđđđđđđđ

}
