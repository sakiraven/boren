package service.client;

import java.util.List;
import java.util.Map;

import entity.Comment;
import entity.Message;

public interface MsCommentService {
	/**
	 * @param comment 
	 * 更改
	 */
	int msAdd(Comment comment,Message message);
	
	/**
	 * @return 查看帖子下评论
	 */
	Map msQueryByCmmtId(Comment comment,int currentPage);
	
	
}
