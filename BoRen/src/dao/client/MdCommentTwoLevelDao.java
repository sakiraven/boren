package dao.client;

import java.util.List;
import java.util.Map;

import entity.CommentTwoLevel;

public interface MdCommentTwoLevelDao {
	/**
	 * @param commtTwo
	 * @return 二级评论显示
	 */
	Map<String, Object> mdQueryByCmmtTwoId(CommentTwoLevel commtTwo,int currentPage);
	
	/**
	 * @return commentTwoLevel
	 * 添加二级回复
	 */
	void mdCmmtTwoAdd(CommentTwoLevel commentTwoLevel) throws Exception;
	/**
	 * @param cmmtId
	 * @return 查看二级评论
	 */
	int mdQueryNum(int cmmtId);
}
