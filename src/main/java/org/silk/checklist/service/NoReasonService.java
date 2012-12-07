package org.silk.checklist.service;

import java.util.List;

import org.silk.checklist.dao.NoReasonDao;
import org.silk.checklist.dao.NoReasonDaoImpl;
import org.silk.checklist.model.NoReason;

public class NoReasonService {
	private NoReasonDao reasonDao = new NoReasonDaoImpl();
	public List<NoReason> getAllNoReasons() {
		// TODO Auto-generated method stub
		return reasonDao.list();
	}

	public void deleteNoReason(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveNoReason(NoReason reason) {
		// TODO Auto-generated method stub
		reasonDao.save(reason);
	}

	public NoReason getNoReason(long id) {
		// TODO Auto-generated method stub
		return reasonDao.getById(id);
	}

	public List<NoReason> getNoReasonOf(Long questionId) {
		// TODO Auto-generated method stub
		return reasonDao.getByQuestionId(questionId);
	}

}
