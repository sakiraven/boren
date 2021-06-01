package controller.mgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import service.mgr.NoticeService;
import entity.Notice;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeServiceImpl;

	@RequestMapping("noticeAll.do")
	@ResponseBody
	public Object getAll() {
		Map myMap = new HashMap<String, Object>();
		myMap.put("list", noticeServiceImpl.getAll());
		return myMap;
	}

	@RequestMapping("delNotice.do")
	@ResponseBody
	public Object delNotice(Notice notice) {
		Map myMap = new HashMap<String, Object>();
		myMap.put("mess", noticeServiceImpl.delNotice(notice));
		return myMap;
	}

	@RequestMapping("addNotice.do")
	@ResponseBody
	public Object addNotice(Notice notice) {
		Map myMap = new HashMap<String, Object>();
		myMap.put("mess", noticeServiceImpl.addNotice(notice));
		return myMap;
	}
}
