package service.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.client.MdNoticeDao;

import entity.Notice;
import service.client.MsNoticeService;

@Service
public class MsNoticeServiceImpl implements MsNoticeService {
	@Autowired
	private MdNoticeDao mdNoticeDaoImpl;
	public Notice msQueryOne() {
		return this.mdNoticeDaoImpl.mdQueryOne();
	}

}
