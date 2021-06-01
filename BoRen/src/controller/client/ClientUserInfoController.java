package controller.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Account;
import entity.EntityUtil;
import entity.ShopList;
import entity.UserInfo;

import service.client.MsUserInfoService;
import service.client.impl.MsFansListServiceImpl;

@Controller
public class ClientUserInfoController extends HibernateDaoSupport {
	private Map<String, Object> reMap;
	@Autowired
	private MsUserInfoService msUserInfoServiceImpl;
	@Autowired
	private MsFansListServiceImpl msFansListServiceImpl;

	/**
	 * @param userInfo
	 * @return 用户查看个人信息
	 */
	@RequestMapping("queryUserInfoOne.do")
	@ResponseBody
	public Object queryUserInfoOne(UserInfo userInfo) {
		reMap = new HashMap<String, Object>();
		UserInfo getUserInfo = this.msUserInfoServiceImpl.msQueryOne(userInfo);
		reMap.put("userInfo", this.utilEnl(getUserInfo));
		return reMap;
	}

	private EntityUtil utilEnl(UserInfo user) {
		EntityUtil enl = new EntityUtil();
		SimpleDateFormat sy = new SimpleDateFormat("yyyy");
		int age = Integer.parseInt(sy.format(new Date()).toString())
				- Integer.parseInt(sy.format(user.getUserTime()).toString())
				+ 1;
		enl.setUserAge(age);
		enl.setUserName(user.getUserName());
		enl.setPostNum(user.getPosts().size());
		enl.setPostCollNum(user.getCollectPosts().size());
		enl.setUserSex(user.getUserSex());
		enl.setUserImg(user.getUserImg());
		enl.setUserFansNum(this.msFansListServiceImpl.msFansNum(user.getUserId()));
		enl.setUserGuanZhu(this.msFansListServiceImpl.msGuanZhuNum(user.getUserId()));
		enl.setUserBalance(user.getUserBalance());
		enl.setUserCoin(user.getUserCoin());
		enl.setUserVip(user.getVips().size());
		enl.setUserEx(user.getUserEx()%100);
		enl.setUserStatus(user.getStatusUser().getStatusId());
		enl.setUserAdmin(user.getAccount().getAdmin().getAdminId());
		enl.setUserLevel((int)Math.ceil((double)user.getUserEx()/(double)100));
		return enl;
	}

	/**
	 * @param userInfo
	 *            充值
	 */
	@RequestMapping("reChange.do")
	@ResponseBody
	public Object reChange(UserInfo userInfo) {
		reMap = new HashMap<String, Object>();
		int result = this.msUserInfoServiceImpl.msReChange(userInfo);
		if (result > 0) {
			reMap.put("result", "充值成功");
			reMap.put("location", "xxx.jsp");
		} else {
			reMap.put("result", "充值失败");
			reMap.put("location", "xxx.jsp");
		}
		return reMap;
	}

	/**
	 * @param userInfo
	 *            消费
	 */
	@RequestMapping("spend.do")
	@ResponseBody
	public Object spend(UserInfo userInfo, ShopList shopList) {
		reMap = new HashMap<String, Object>();
		int result = this.msUserInfoServiceImpl.msSpend(userInfo, shopList);
		if (result > 0) {
			reMap.put("result", "购买成功");
			reMap.put("location", "xxx.jsp");
		} else if (result == 0) {
			reMap.put("result", "余额不足，请充值");
			reMap.put("location", "xxx.jsp");
		} else if (result == -1) {
			reMap.put("result", "充值异常，请联系管理员qq714158220");
			reMap.put("location", "xxx.jsp");
		}
		return this.reMap;
	}

	/*// 获取所有账号
	@RequestMapping("allUserInfo.do")
	@ResponseBody
	public Object findAll(UserInfo userInfo) {
		Map<String, Object> myMap = new HashMap<String, Object>();
		DetachedCriteria crit = DetachedCriteria.forClass(UserInfo.class);
		List list1 = this.getHibernateTemplate().findByCriteria(crit);
		myMap.put("list", list1);
		return myMap;

	}*/

	// 签到
	@RequestMapping("sign.do")
	@ResponseBody
	public Object sign(UserInfo userInfo) {
		this.reMap = new HashMap<String, Object>();
		int result = this.msUserInfoServiceImpl.msSign(userInfo);
		this.reMap.put("result", result);
		return this.reMap;
	}
}
