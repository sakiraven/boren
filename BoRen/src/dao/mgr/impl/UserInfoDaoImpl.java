package dao.mgr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.mgr.UserInfoDao;
import entity.Account;
import entity.Admin;
import entity.EntityUtil;
import entity.StatusUser;
import entity.UserInfo;
import entity.Vip;

@Repository
public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao {
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
	public Map<String, Object> findAll(UserInfo userInfo,
			UserInfoDaoImpl userInfoDao) {
		Session session = null;
		Map<String, Object> myMap = new HashMap<String, Object>();

		session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hql = "from UserInfo where 1=1";
		// 分页
		Query query = session.createQuery(hql);
		int count = query.list().size();
		// 模糊查询
		if (userInfo != null) {
			if (userInfo.getUserName() != null
					|| userInfo.getUserName().equals("")) {
				hql += "  and userName like '%" + userInfo.getUserName() + "%'";
			}
		}
		this.setCurrSize(userInfoDao.getCurrSize());
		this.setCountSize(count);
		this.setCurrPage(userInfoDao.getCurrPage());
		int firstResult = (this.getCurrPage() - 1) * this.getCurrSize();
		List<UserInfo> getlt = session.createQuery(hql)
				.setFirstResult(firstResult).setMaxResults(this.getCurrSize())
				.list();

		List list1 = new ArrayList();
		for (UserInfo user : getlt) {
			EntityUtil entityUtil = new EntityUtil();
			Account acct = new Account();
			acct.setAcctId(user.getAccount().getAcctId());
			acct.setAcctName(user.getAccount().getAcctName());
			entityUtil.setAccount(acct);
			Admin admin = new Admin();
			admin.setAdminId(user.getAccount().getAdmin().getAdminId());
			admin.setAdminName(user.getAccount().getAdmin().getAdminName());
			entityUtil
					.setAdminName(user.getAccount().getAdmin().getAdminName());
			entityUtil.setAdmin(admin);
			StatusUser statusUser = new StatusUser();
			if (user.getStatusUser() != null) {
				statusUser.setStatusId(user.getStatusUser().getStatusId());
				statusUser.setStatusTime(user.getStatusUser().getStatusTime());
			}
			entityUtil.setStatusUser(statusUser);
			UserInfo userInfo1 = new UserInfo();
			userInfo1.setUserId(user.getUserId());
			userInfo1.setUserPhone(user.getUserPhone());
			userInfo1.setUserName(user.getUserName());
			userInfo1.setUserTime(user.getUserTime());
			entityUtil.setUserInfo(userInfo1);
			list1.add(entityUtil);
		}
		myMap.put("list", list1);
		myMap.put("countSize", count);
		myMap.put("countPage", this.getCountPage());
		myMap.put("currPage", this.getCurrPage());

		return myMap;

	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		commonCURD.modifyObj(userInfo, commonCURD.UPDATE);
	}

	@Override
	public UserInfo findUserInfo(Integer userId) {
		return (UserInfo) commonQueryDao.queryById(UserInfo.class, userId);
	}

	@Override
	public Map<String, Object> typeUser(Object[] array) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		Map<String, Object> myMap1 = new HashMap<String, Object>();
		HibernateTemplate template = this.getHibernateTemplate();
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.openSession();
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
		List year = new ArrayList();
		Integer index = 0;
		for (int i = 0; i < array.length; i++) {
			Map map = (Map) array[i];
			String hql = "from UserInfo where  userTime >='" + map.get("Start")
					+ "' and  userTime <'" + map.get("End") + "'";
			List<UserInfo> myList = session.createQuery(hql).list();
			for (UserInfo obj : myList) {
				EntityUtil entity = new EntityUtil();
				// 管理员
				Admin admin = new Admin();
				admin.setAdminId(obj.getAccount().getAdmin().getAdminId());
				admin.setAdminName(obj.getAccount().getAdmin().getAdminName());
				// 账号
				Account acc = new Account();
				acc.setAcctId(obj.getAccount().getAcctId());
				acc.setAcctName(obj.getAccount().getAcctName());
				// vip
				Vip vip = new Vip();
				vip.setUserInfo(obj);
				entity.setAccount(acc);
				entity.setAdmin(admin);
				entity.setVip(vip);
				if (obj.getVips().size() != 0
						&& obj.getAccount().getAdmin().getAdminId() == 1) {
					list1.add(entity);
				} else if (obj.getAccount().getAdmin().getAdminId() == 2
						&& obj.getVips().size() == 0) {
					list2.add(entity);
				} else {
					list3.add(entity);
				}

			}
			myMap.put("putong", list3);
			myMap.put("vip", list1);
			myMap.put("admin", list2);
			year.add(myMap);

			String ss = index.toString();
			myMap1.put(ss, year);
			index++;

		}

		return myMap1;
	}
}
