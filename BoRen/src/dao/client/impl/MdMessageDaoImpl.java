package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import dao.ICommonCURD;
import dao.client.MdMessageDao;
import entity.Account;
import entity.Message;
@Repository
public class MdMessageDaoImpl extends HibernateDaoSupport implements MdMessageDao {

	@Autowired
	private CommonQueryDao commonQueryDao;
	@Autowired
	private ICommonCURD commonCURD;
	//添加消息
	public void mdAddMessage(Message message) {
		this.commonCURD.modifyObj(message, this.commonCURD.SAVE);
	}
	//查询所有
	public List<Message> mdQueryMessageAll(Account account){
		String queryString = "from Message where msg_send_to_id=?";
		return this.getHibernateTemplate().find(queryString,account.getAcctId());
	}
	//用户查询消息
	public List<Message> mdQueryUserInfo(Message message) {
		String queryString = "from Message where msg_send_to_id=? and msg_status !=1";
		return this.getHibernateTemplate().find(queryString, message.getUserInfoByMsgSendToId().getAccount().getAcctId());
	}
	//更改阅读状态
	public void mdChange(List<Message> messLt) {
		for (Message message : messLt) {
			message.setMsgStatus(1);
			this.commonCURD.modifyObj(message, this.commonCURD.UPDATE);
		}
	}
	//删除全部
	public void mdDel(List<Message> msgLt) {
		for (Message message : msgLt) {
			this.commonCURD.modifyObj(message, this.commonCURD.DEL);
		}
	}
}
