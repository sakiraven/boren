package controller.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Comment;
import entity.CommentTwoLevel;
import entity.EntityUtil;
import entity.Message;

import service.client.MsCommentTwoService;

@Controller
public class ClientCommentTwoLevelController {
	Map<String, Object> reMap;
	@Autowired
	private MsCommentTwoService msCommentTwoService;
	/**
	 * @param commentTwoLevel
	 * @param message
	 * @return 添加二级评论
	 */
	@RequestMapping("addCommentTwoLevel.do")
	@ResponseBody
	public Object clientCommentTwoAdd(CommentTwoLevel commentTwoLevel,Message message){
		int result = this.msCommentTwoService.msCommentTwoAdd(commentTwoLevel,message);
		reMap = new HashMap<String, Object>();
		if(result==1)
			reMap.put("result", "添加成功");
		if(result==-1)
			reMap.put("result", "添加失败");
		return reMap;
	}
	
	/*@RequestMapping("queryCommentTwoLevel.do")
	@ResponseBody
	public Object clientQueryCommentTwoLevel(CommentTwoLevel commentTwoLevel,int currentPage){
		Map reMap =null;
		try {
			reMap =  this.nutilCmmtTwo(this.msCommentTwoService.msQueryCmmtTwoByCmmtId(commentTwoLevel,currentPage));	
		} catch (Exception e) {
		}
		
		return reMap;
	}*/
	
	/**
	 * @param commentTwoLevel
	 * @param currentPage
	 * @return 查看二级评论
	 */
	@RequestMapping("queryCommentTwoLevel.do")
	@ResponseBody
	public Object clientQueryCommentTwoLevel(CommentTwoLevel commentTwoLevel,int currentPage){
		Map reMap =null;
		try {
			reMap =  this.nutilCmmtTwo(this.msCommentTwoService.msQueryCmmtTwoByCmmtId(commentTwoLevel,currentPage));	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return reMap;
	}
	/**
	 * @param getMap
	 * @return 封装
	 */
	private Map<String, Object> nutilCmmtTwo(Map<String, Object> getMap){
		List<EntityUtil> reLt=null;
			List<CommentTwoLevel> getLt = (List<CommentTwoLevel>) getMap
					.get("commentTwoList");
			 reLt = new ArrayList<EntityUtil>();
			for (CommentTwoLevel two : getLt) {
				EntityUtil enl = new EntityUtil();
				enl.setCmmtFloor(two.getCmmtFloor());
				enl.setCmmtTwoId(two.getCmmtTwoId());
				enl.setCmmtTwoText(two.getCmmtTwoText());
				enl.setSendId(two.getUserInfoByCmmtSendId().getAccount()
						.getAcctId());
				enl.setSendToId(two.getUserInfoByCmmtSendToId().getAccount()
						.getAcctId());
				enl.setSendName(two.getUserInfoByCmmtSendId().getUserName());
				enl.setSendToName(two.getUserInfoByCmmtSendToId().getUserName());
				enl.setSendUserImg(two.getUserInfoByCmmtSendId().getUserImg());
				enl.setSendToUserImg(two.getUserInfoByCmmtSendToId()
						.getUserImg());
				enl.setCmmtId(two.getComment().getCmmtId());
				enl.setCmmtTime(two.getCmmtTime());
				enl.setCmmtTwoNum(this.msCommentTwoService.msQueryNum(two.getComment().getCmmtId()));
				reLt.add(enl);
			}
			
		getMap.put("commentTwoList", reLt);
		return getMap;
	}
}
