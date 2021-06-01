package dao.client;

import entity.Notice;

public interface MdNoticeDao {
	/**
	 * @return 查看公告
	 */
	Notice mdQueryOne();
}
