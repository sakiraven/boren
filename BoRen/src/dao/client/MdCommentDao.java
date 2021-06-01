package dao.client;

import java.util.List;
import java.util.Map;

import entity.Comment;

public interface MdCommentDao {
	/**
	 * @param comment 
	 * 更改
	 */
	void mdAdd(Comment comment) throws Exception;
	
	/**
	 * @param comment
	 * @return 查询帖子下评论
	 */
	 Map<String, Object> mdQueryByPostId(Comment comment,int currentPage);
	
}
