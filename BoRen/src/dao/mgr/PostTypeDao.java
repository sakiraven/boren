package dao.mgr;

import java.util.List;

import entity.PostType;

public interface PostTypeDao {
	//查询所有板块类型
	List<PostType> getAll();
	//删除板块类型
	void delPostType(PostType postType);
	//添加板块类型
	void savePostType(PostType postType);	
}
