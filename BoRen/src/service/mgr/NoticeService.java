package service.mgr;

import java.util.List;

import entity.Notice;

public interface NoticeService {
	// 查询所有新闻
	List<Notice> getAll();

	// 按照ID删除
	String delNotice(Notice notice);

	// 添加所有新闻

	String addNotice(Notice notice);
}
