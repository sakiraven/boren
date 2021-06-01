package dao.client;

import java.util.List;
import java.util.Map;

import entity.Post;
import entity.PostType;

public interface MdPostDao {
	/**
	 * @return 查看所有帖子
	 */
	List<Post> mdQueryAll();

	/**
	 * @param post
	 * @return 搜索查询
	 */
	Map<String, Object> mdQueryAll(Post post, int currentPage);

	/**
	 * 创建帖子
	 */
	void mdAdd(Post post) throws Exception;

	/**
	 * @param post
	 * @return id查询帖子
	 */
	Post mdQueryOneById(Post post);
	
	/**
	 * @param post
	 * 更改
	 */
	void mdChange(Post post) throws Exception;
	
	/**
	 * @param postType
	 * @return 类型查看
	 */
	Map<String, Object> mdQueryTypeAll(PostType postType,int currentPage,String postTitle);
	
	/** 
	 * @param postType
	 * @return 热度排序
	 */
	List<Post> mdQueryLoveAll(PostType postType);
}
