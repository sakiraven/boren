package service.mgr;

import java.util.List;

import entity.PostType;

public interface PostTypeService {
	// 查询所有板块类型
	List<PostType> getAll();

	// 删除板块类型
	String delPostType(PostType postType);

	// 添加板块类型
	String savePostType(PostType postType);
}
