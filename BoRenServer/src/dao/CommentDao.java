package dao;

import java.util.List;

import entity.Comment;

public interface CommentDao {

	List<Comment> commentQueryByCmmtId(Comment comment);
	
	int commentSize(Comment comment);

	void commentAdd(Comment comment) throws Exception;
}
