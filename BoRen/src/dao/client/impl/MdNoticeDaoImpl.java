package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.client.MdNoticeDao;
import entity.Notice;
@Repository
public class MdNoticeDaoImpl implements MdNoticeDao {
@Autowired
private CommonQueryDao commonQueryDao;
	public Notice mdQueryOne() {
		List<Notice> reLt = this.commonQueryDao.queryAll(Notice.class);
		return reLt.isEmpty()?null:reLt.get(0);
	}

}
