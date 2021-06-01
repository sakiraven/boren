package service.client;

import java.util.List;
import java.util.Map;

import entity.EntityUtil;
import entity.Post;
import entity.PostType;

public interface MsPostService {
	/**
	 * @return 查看所有帖子
	 */
	List<Post> msQueryAll();

	/**
	 * @param post
	 * @return 按名称查询
	 */
	Map<String, Object> msQueryAllLike(Post post, int currentPage);

	/**
	 * 创建帖子
	 */
	int msAdd(Post post);

	/**
	 * @param post
	 * @return id查询帖子
	 */
	List<EntityUtil> msQueryOneById(Post post,int fansId);
	
	/**
	 * @param post
	 * @return 点赞
	 */
	int msLove(Post post,int sendId,int sendToId);
	
	/**
	 * @param postType
	 * @return 类型查询
	 */
	Map<String,Object> msQueryType(PostType postType,int currentPage,String postTitle);
	
	/**
	 * @return 热度排序
	 */
	List<EntityUtil> msQueryLoveType(PostType postType);
	
	/**
	 * @param post
	 * @return 投币
	 */
	int msTouB(int postId,int sendId,int sendToId);
}
