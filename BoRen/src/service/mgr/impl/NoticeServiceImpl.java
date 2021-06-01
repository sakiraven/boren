package service.mgr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.NoticeService;
import dao.mgr.NoticeDao;
import entity.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao NoticeDaoImpl;

	@Override
	public List<Notice> getAll() {
		return NoticeDaoImpl.getAll();
	}

	@Override
	public String delNotice(Notice notice) {
		if (notice.getNoticeId() != null) {
			NoticeDaoImpl.delNotice(notice);
			return "删除成功!";
		}
		return "删除失败!";
	}

	@Override
	public String addNotice(Notice notice) {
		if ((notice.getNoticeTitle() != null && !notice.getNoticeTitle()
				.equals(""))
				&& (notice.getNoticeText() != null && !notice.getNoticeTitle()
						.equals(""))) {
			NoticeDaoImpl.addNotice(notice);
			return "添加成功！";
		}
		return "添加失败！";
	}
}
