package dao;

import java.util.List;

import entity.Account;
import entity.CollectPost;

public interface CollectPostDao {
	List<CollectPost> queryOneByPostId(CollectPost cp);

	void addColl(CollectPost cp);
	
	
}
