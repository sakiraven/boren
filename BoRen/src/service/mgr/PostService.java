package service.mgr;

import java.util.Map;

import dao.mgr.impl.PostDaoImpl;
import entity.Post;

public interface PostService {
	// 查询相应类型帖子(分页)
	Map getAll(Integer currPage, Integer typeId);

	// 删除帖子
	String delPost(Post post);
}
