package service.client.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdCommentDao;
import dao.client.MdCommentTwoLevelDao;
import dao.client.MdMessageDao;
import dao.client.MdUserInfoDao;

import entity.Comment;
import entity.CommentTwoLevel;
import entity.Message;
import entity.UserInfo;
import service.client.MsCommentTwoService;

@Service
public class MsCommentTwoServiceImpl implements MsCommentTwoService {
	@Autowired
	private MdCommentTwoLevelDao mdCommentTwoLevelDaoImpl;
	@Autowired
	private MdUserInfoDao  mdUserInfoDaoImpl;
	@Autowired
	private MdMessageDao  mdMessageDaoImpl;
	//添加二级评论
	public int msCommentTwoAdd(CommentTwoLevel commentTwoLevel,Message message) {
		int result= 1;
		try {
			UserInfo send =  this.mdUserInfoDaoImpl.mdQueryOne(message.getUserInfoByMsgSendId());
			UserInfo sendTo = this.mdUserInfoDaoImpl.mdQueryOne(message.getUserInfoByMsgSendToId());
			commentTwoLevel.setUserInfoByCmmtSendId(send);
			commentTwoLevel.setUserInfoByCmmtSendToId(sendTo);
			this.mdCommentTwoLevelDaoImpl.mdCmmtTwoAdd(commentTwoLevel);
			message.setUserInfoByMsgSendId(send);
			message.setUserInfoByMsgSendToId(sendTo);
			message.setMsgType(1);
			if(send.getAccount().getAcctId()!=sendTo.getAccount().getAcctId())
				this.mdMessageDaoImpl.mdAddMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}
	//查询二级评论
	public Map<String, Object> msQueryCmmtTwoByCmmtId(
			CommentTwoLevel commentTwoLevel,int currentPage) {
		return this.mdCommentTwoLevelDaoImpl.mdQueryByCmmtTwoId(commentTwoLevel,currentPage);
	}
	
	public int msQueryNum(int cmmtId) {
	
		return 	this.mdCommentTwoLevelDaoImpl.mdQueryNum(cmmtId);
	}

}
