package dao.mgr;

import java.util.Map;

import dao.mgr.impl.PostDaoImpl;
import entity.Post;

public interface PostDao {
	// 查询相应类型帖子(分页)
	// Map getAll(PostDaoImpl postDaoImpl, Post post);
	Map getAll(Integer currSize, Integer currPage, Post post);

	// 删除帖子
	void delPost(Post post);
}
