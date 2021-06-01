package service.client;

import java.util.List;

import entity.GmEmail;

public interface MsGmEmailService {
	/**
	 * @param gmEmail
	 * 改变gm
	 */
	int msAddGm(GmEmail gmEmail);
	
	/**
	 * @param gmEmail
	 * @return 查询
	 */
	List<GmEmail> msQueryGm(GmEmail gmEmail);
	
	/**
	 * @param msStatusGm
	 * @return 更改阅读状态
	 */
	List<GmEmail> msStatusGm(GmEmail gmEmail);
}
