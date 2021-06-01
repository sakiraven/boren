package dao;

import org.apache.ibatis.annotations.Param;

public interface VipDao {
	int isVip(@Param("userId")int userId);
	
}
