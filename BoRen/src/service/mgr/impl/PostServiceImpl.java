package service.mgr.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.PostService;
import dao.mgr.PostDao;
import dao.mgr.impl.PostDaoImpl;
import entity.Post;
import entity.PostType;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDaoImpl;

	@Override
	public Map getAll(Integer currPage, Integer typeId) {
		Post post = new Post();
		PostType postType = new PostType();
		postType.setPostTypeId(typeId);
		post.setPostType(postType);
		return postDaoImpl.getAll(6, currPage, post);
	}

	@Override
	public String delPost(Post post) {
		if (post != null) {
			if (post.getPostId() != null && !post.getPostId().equals("")) {
				postDaoImpl.delPost(post);
				return "删除成功!";
			}
		}
		return "删除失败";
	}

}
