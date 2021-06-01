package dao.mgr;

import java.util.List;

import entity.Notice;

public interface NoticeDao {
	// 查询所有新闻
	List getAll();

	// 按照ID删除
	void delNotice(Notice notice);

	// 添加所有新闻

	void addNotice(Notice notice);
}
