package dao.mgr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.GmEmailDao;
import entity.EmailType;
import entity.EntityUtil;
import entity.GmEmail;
import entity.UserInfo;

@Repository
public class GmEmailDaoImpl extends HibernateDaoSupport implements GmEmailDao {
	@Autowired
	ICommonCURD commonCURD;
	@Autowired
	CommonQueryDao commonQueryDao;
	private Integer currPage = 1;// 当前页数
	private Integer countSize;// 数据总条数
	private Integer countPage;// 总页数
	private Integer currSize;// 每页显示数量

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		if (currPage < 0) {
			this.currPage = 1;
		} else {
			this.currPage = currPage;
		}
	}

	public Integer getCountSize() {
		return countSize;
	}

	public void setCountSize(Integer countSize) {
		this.countSize = countSize;
		int size = this.currSize;
		this.countPage = countSize % this.currSize == 0 ? countSize
				/ this.currSize : (countSize / this.currSize) + 1;
	}

	public Integer getCountPage() {
		return countPage;
	}

	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}

	public Integer getCurrSize() {
		return currSize;
	}

	public void setCurrSize(Integer currSize) {
		this.currSize = currSize;
	}

	@Override
	public Map getGmEmail(Integer emailId) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from GmEmail where 1=1 and emailId=" + emailId;
		List<GmEmail> getlt = session.createQuery(hql).list();
		List list = new ArrayList();
		for (GmEmail gmEmail : getlt) {
			EntityUtil entityUtil = new EntityUtil();
			EmailType emailType = new EmailType();
			emailType.setEmailType(gmEmail.getEmailType().getEmailType());
			emailType.setEmailTypeId(gmEmail.getEmailType().getEmailTypeId());
			entityUtil.setEmailType(emailType);
			UserInfo userInfo = new UserInfo();
			if (gmEmail.getUserInfoByEmailSendId() != null) {
				userInfo.setUserId(gmEmail.getUserInfoByEmailSendId()
						.getUserId());

				userInfo.setUserName(gmEmail.getUserInfoByEmailSendId()
						.getUserName());
			}
			entityUtil.setUserInfo(userInfo);
			GmEmail gmEmail1 = new GmEmail();
			gmEmail1.setEmailId(gmEmail.getEmailId());
			gmEmail1.setEmailQuote(gmEmail.getEmailQuote());
			gmEmail1.setEmailStatus(gmEmail.getEmailStatus());
			gmEmail1.setEmailText(gmEmail.getEmailText());
			gmEmail1.setEmailTime(gmEmail.getEmailTime());
			gmEmail1.setEmailType_1(gmEmail.getEmailType_1());
			entityUtil.setGmEmail(gmEmail1);
			list.add(entityUtil);
		}
		myMap.put("list", list);
		return myMap;
	}

	@Override
	public void delGmEmail(GmEmail gmEmail) {
		commonCURD.modifyObj(gmEmail, commonCURD.DEL);
	}

	@Override
	public void addGmEmail(GmEmail gmEmail) {
		commonCURD.modifyObj(gmEmail, commonCURD.SAVE);
	}

	@Override
	public Map getAll(GmEmailDaoImpl gmEmailDaoIpl, GmEmail emEmil) {
		Session session = null;
		Map<String, Object> myMap = new HashMap<String, Object>();
		session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hql = "from GmEmail where 1=1 and emailType_1=1";
		// 分页
		Query query = session.createQuery(hql);
		this.setCurrSize(gmEmailDaoIpl.getCurrSize());
		this.setCurrPage(gmEmailDaoIpl.getCurrPage());
		int firstResult = (this.getCurrPage() - 1) * this.getCurrSize();
		if (emEmil.getEmailType() != null) {
			if (emEmil.getEmailType().getEmailTypeId() == 1) {
				hql += " and emailType.emailTypeId in(1,2)";
			} else {
				hql += " and emailType.emailTypeId = "
						+ emEmil.getEmailType().getEmailTypeId();
			}
		}
		int count = session.createQuery(hql).list().size();
		this.setCountSize(count);
		List<GmEmail> getlt = session.createQuery(hql)
				.setFirstResult(firstResult).setMaxResults(this.getCurrSize())
				.list();
		List list = new ArrayList();
		for (GmEmail gmEmail : getlt) {
			EntityUtil entityUtil = new EntityUtil();
			EmailType emailType = new EmailType();
			emailType.setEmailType(gmEmail.getEmailType().getEmailType());
			emailType.setEmailTypeId(gmEmail.getEmailType().getEmailTypeId());
			entityUtil.setEmailType(emailType);
			UserInfo userInfo = new UserInfo();
			if (gmEmail.getUserInfoByEmailSendId() != null) {
				userInfo.setUserId(gmEmail.getUserInfoByEmailSendId()
						.getUserId());

				userInfo.setUserName(gmEmail.getUserInfoByEmailSendId()
						.getUserName());
			}
			entityUtil.setUserInfo(userInfo);
			GmEmail gmEmail1 = new GmEmail();
			gmEmail1.setEmailId(gmEmail.getEmailId());
			gmEmail1.setEmailQuote(gmEmail.getEmailQuote());
			gmEmail1.setEmailStatus(gmEmail.getEmailStatus());
			gmEmail1.setEmailText(gmEmail.getEmailText());
			gmEmail1.setEmailTime(gmEmail.getEmailTime());
			gmEmail1.setEmailType_1(gmEmail.getEmailType_1());
			entityUtil.setGmEmail(gmEmail1);
			list.add(entityUtil);
		}
		myMap.put("list", list);
		myMap.put("countPage", this.getCountPage());
		myMap.put("currPage", this.getCurrPage());
		session.clear();
		session.close();
		return myMap;
	}

	@Override
	public void updateGmEmail(GmEmail gmEmail) {
		GmEmail gmEmail1 = (GmEmail) commonQueryDao.queryById(GmEmail.class,
				gmEmail.getEmailId());
		gmEmail1.setEmailStatus(1);
		commonCURD.modifyObj(gmEmail1, commonCURD.UPDATE);
	}
}
