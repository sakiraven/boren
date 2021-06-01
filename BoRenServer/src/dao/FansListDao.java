package dao;

import org.apache.ibatis.annotations.Param;

import entity.FansList;

public interface FansListDao {
	int isFans(@Param("fansId")int fansId ,@Param("userId")int userId);
	
	int fanNums(int userId);

	void addUser(FansList fansList);
	
}
