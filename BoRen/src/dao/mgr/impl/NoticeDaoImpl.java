package dao.mgr.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.NoticeDao;
import entity.EntityUtil;
import entity.Notice;

@Repository
public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {
	@Autowired
	CommonQueryDao commonQueryDao;
	@Autowired
	ICommonCURD commonCURD;

	@Override
	public List getAll() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from Notice where 1=1";
		List<Notice> list = session.createQuery(hql).list();
		List list1 = new ArrayList();
		for (Notice notice : list) {
			Notice notice1 = new Notice();
			EntityUtil entity = new EntityUtil();
			notice1.setNoticeId(notice.getNoticeId());
			notice1.setNoticeText(notice.getNoticeText());
			notice1.setNoticeTitle(notice.getNoticeTitle());
			entity.setNotice(notice1);
			list1.add(entity);
		}
		return list1;
	}

	@Override
	public void delNotice(Notice notice) {
		commonCURD.modifyObj(notice, commonCURD.DEL);
	}

	@Override
	public void addNotice(Notice notice) {
		commonCURD.modifyObj(notice, commonCURD.SAVE);

	}

}
