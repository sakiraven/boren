package service.client.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdCommentDao;
import dao.client.MdMessageDao;
import dao.client.MdUserInfoDao;

import entity.Comment;
import entity.Message;
import entity.UserInfo;
import service.client.MsCommentService;
import service.client.MsPostService;
@Service
public class MsCommentServiceImpl implements MsCommentService{
	@Autowired
	private MdCommentDao mdCommentDaoImpl;
	@Autowired
	private MsPostService mdPostServiceImpl;
	@Autowired
	private MdMessageDao mdMessageDaoImpl;
	@Autowired
	private MdUserInfoDao mdUserInfoDaoImpl;
	//添加评论
	public int msAdd(Comment comment,Message message) {
		int result = 1;
		List<Comment> getlt =(List<Comment>) this.mdCommentDaoImpl.mdQueryByPostId(comment,-1).get("commentList");
		UserInfo send = this.mdUserInfoDaoImpl.mdQueryOne(message.getUserInfoByMsgSendId());
		UserInfo sendTo = this.mdUserInfoDaoImpl.mdQueryOne(message.getUserInfoByMsgSendToId());
		comment.setUserInfo(send);
		comment.setCmmtFloor(getlt.size()+2);
		message.setMsgType(0);
		message.setUserInfoByMsgSendId(send);
		message.setUserInfoByMsgSendToId(sendTo);
		try {
			this.mdCommentDaoImpl.mdAdd(comment);
			if(message.getUserInfoByMsgSendId()!=message.getUserInfoByMsgSendToId())
				this.mdMessageDaoImpl.mdAddMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}
	//查看评论
	public Map msQueryByCmmtId(Comment comment,int currentPage) {
		return this.mdCommentDaoImpl.mdQueryByPostId(comment,currentPage); 
	}

}
