package dao;

import java.util.List;
import entity.CommentTwoLevel;
public interface CommentTwoLevelDao {
	List<CommentTwoLevel> queryCmmtTwoOne(CommentTwoLevel cmtTwo);

	int commentTwoSize(CommentTwoLevel commentTwoLevel);

	void addCommentTwoLevel(CommentTwoLevel commentTwoLevel) throws Exception;
	
}
