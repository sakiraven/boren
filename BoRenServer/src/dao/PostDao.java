package dao;

import java.util.List;

import entity.Post;
public interface PostDao {
	List<Post> postLoveQuery(Post post);

	List<Post> postTypeQuery(Post post);

	void postAdd(Post post) throws Exception;
	
	int postSize(Post post);

	List<Post> postQueryOneById(Post post);

	void updateB(Post post);
	
	List<Post> postBQuery(Post post);

	void postLove(Post post);
}
