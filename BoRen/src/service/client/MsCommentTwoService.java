package service.client;

import java.util.List;
import java.util.Map;

import entity.Comment;
import entity.CommentTwoLevel;
import entity.Message;

public interface MsCommentTwoService {
	/**
	 * @param commentTwoLevel
	 *  插入评论
	 */
	int msCommentTwoAdd(CommentTwoLevel commentTwoLevel,Message message);
	
	/**
	 * @return 查询二级评论
	 */
	/*Map<String, Object> msQueryCmmtTwoByCmmtId(CommentTwoLevel commentTwoLevel,int currentPage);*/
	Map<String, Object> msQueryCmmtTwoByCmmtId(CommentTwoLevel commentTwoLevel,int currentPage);
	/**
	 * @param cmmtId
	 * @return 查询二级评论数量
	 */
	int msQueryNum(int cmmtId);
}
