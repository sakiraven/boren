package dao.client.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CommonQueryDao;
import entity.EmailType;

@Repository
public class MdGmEmailTypeDaoImpl {
	@Autowired
	private CommonQueryDao commonQueryDao;

	public EmailType getType(int typeId) {
		EmailType getlt =(EmailType) this.commonQueryDao
				.queryById(EmailType.class, typeId);
		return getlt;
	}
}
