package controller.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.client.MsCommentService;

import dao.client.MdCommentDao;
import dao.client.impl.MdFansListDaoImpl;

import entity.Comment;
import entity.EntityUtil;
import entity.Message;

@Controller
public class ClientCommentController {
	Map<String, Object> reMap;
	@Autowired
	private MsCommentService msCommentServiceImpl;
	@Autowired
	private MdFansListDaoImpl mdFansListDaoImpl;
	
	/**
	 * @param comment
	 * 评论帖子
	 */
	@RequestMapping("commentAdd.do")
	@ResponseBody
	public Object commentAdd(Comment comment,Message message){
		reMap=new HashMap<String, Object>();
		int key = this.msCommentServiceImpl.msAdd(comment,message);
		if(key>0)
			this.reMap.put("result","评论成功");
		else
			this.reMap.put("result", "评论异常，请联系管理员qq714158220");
		return reMap;
	}
	
	/**
	 * @param comment
	 * 查看帖子评论
	 */
	@RequestMapping("commentQueryByCmmtId.do")
	@ResponseBody
	public Object commentQueryByCmmtId(Comment comment,int currentPage,int acctId){
		Map<String,Object> getMap = this.msCommentServiceImpl.msQueryByCmmtId(comment,currentPage);
		List<Comment> getLt =(List<Comment>) getMap.get("commentList");
		getMap.remove("commentList");
		getMap.put("commentList", this.utilComment(getLt,acctId));
		return getMap;
	}
	
	private List<EntityUtil> utilComment(List<Comment> getCmmt,int acctId){
		System.out.println("my"+acctId);
		this.reMap=new HashMap<String, Object>();
		List<EntityUtil> getLt = new ArrayList<EntityUtil>();
		for (Comment cmmt : getCmmt) {
			EntityUtil enl = new EntityUtil();
			enl.setCmmtFloor(cmmt.getCmmtFloor());
			enl.setCmmtId(cmmt.getCmmtId());
			enl.setCmmtTime(cmmt.getCmmtTime());
			enl.setUserName(cmmt.getUserInfo().getUserName());
			enl.setAcctId(cmmt.getUserInfo().getAccount().getAcctId());
			enl.setUserVip(cmmt.getUserInfo().getVips().size());
			enl.setCmmtText(cmmt.getCmmtText());
			SimpleDateFormat sy=new SimpleDateFormat("yyyy");
			int age = Integer.parseInt(sy.format(new Date()).toString())-Integer.parseInt(sy.format(cmmt.getUserInfo().getUserTime()).toString())+1;
			enl.setUserAge(age);
			enl.setCmmtTwoNum(cmmt.getCommentTwoLevels().size());
			enl.setSendUserImg(cmmt.getUserInfo().getUserImg());
			enl.setPostCoinNum(cmmt.getPost().getPostCoinNum());
			enl.setUserFansNum(this.mdFansListDaoImpl.mdFansNum(cmmt.getUserInfo().getAccount().getAcctId()));
			enl.setUserIsFans(this.mdFansListDaoImpl.mdIsFan(acctId, cmmt.getUserInfo().getAccount().getAcctId()));
			getLt.add(enl);
		}
		return getLt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
