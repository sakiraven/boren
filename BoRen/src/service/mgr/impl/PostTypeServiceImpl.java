package service.mgr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.mgr.PostTypeService;

import dao.mgr.PostTypeDao;
import entity.PostType;

@Service
public class PostTypeServiceImpl implements PostTypeService {
	@Autowired
	PostTypeDao postTypeDaoImpl;

	@Override
	public List<PostType> getAll() {
		return postTypeDaoImpl.getAll();
	}

	@Override
	public String delPostType(PostType postType) {
		if (postType != null) {
			if ((postType.getPostTypeId() != null && !postType.getPostTypeId()
					.equals(""))
					&& (!postType.getPostStatus().equals("") && postType
							.getPostStatus() != null)) {
				postTypeDaoImpl.delPostType(postType);
				return "删除成功！";
			}

		}
		return "删除失败!";
	}

	@Override
	public String savePostType(PostType postType) {
		if (postType != null) {
			if ((postType.getPostStatus().equals("") && postType
					.getPostStatus() != null)
					&& (postType.getPostType().equals("") && postType
							.getPostType() != null)) {
				postTypeDaoImpl.savePostType(postType);
				return "创建成功！";
			}
		}
		return "创建失败!";
	}
}
