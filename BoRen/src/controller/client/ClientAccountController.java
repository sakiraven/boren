package controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.MsAccountService;
import service.client.impl.MsAccountServiceImpl;

import dao.client.MdUserInfoDao;
import dao.client.impl.MdAccountDaoImpl;
import dao.client.impl.MdUserInfoDaoImpl;

import entity.Account;
import entity.UserInfo;

@Controller
public class ClientAccountController {
	private Map<String, Object> reMap;
	@Autowired
	private MsAccountService msAccountServiceImpl;
	@Autowired
	private MdUserInfoDaoImpl mdUserInfoDaoImpl;
	
	/**
	 * @param account
	 * @return 登陆
	 */
	@RequestMapping("clientLogin.do")
	@ResponseBody
	public Object clientLogin(Account account){
		reMap=new HashMap<String, Object>();
		Account getAccount = this.msAccountServiceImpl.msLogin(account);
		
		if(getAccount!=null){
			reMap.put("acctId", getAccount.getAcctId());
			reMap.put("adminId", getAccount.getAdmin().getAdminId());
			if(this.mdUserInfoDaoImpl.mdFengJin(getAccount.getAcctId())==1){
				reMap.put("result", -1);
			}
		}
		else
			reMap.put("acctId", -1);
		
		
		return reMap;
	}
	
	/**
	 * @param account
	 * @param userInfo
	 * @return 注册
	 */
	@RequestMapping("clientAddAccount.do")
	@ResponseBody
	public Object clientAddAccount(Account account,UserInfo userInfo){
		reMap=new HashMap<String, Object>();
		int key = this.msAccountServiceImpl.msAdd(account, userInfo);
		if(key>0){
			reMap.put("result", "注册成功");
		}else{
			reMap.put("result", "注册失败");
		}
		return reMap;
	}
	
}
