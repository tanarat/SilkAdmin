package org.silk.checklist.service;

import java.util.List;


import org.silk.checklist.dao.EvalFormDao;
import org.silk.checklist.dao.EvalFormDaoImpl;
import org.silk.checklist.model.EvalForm;

public class EvalFormService {
	private EvalFormDao formDao = new EvalFormDaoImpl();
	public List<EvalForm> getAllEvalForms() {
		// TODO Auto-generated method stub
		return formDao.list();
	}

	public void deleteEvalForm(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveEvalForm(EvalForm form) {
		// TODO Auto-generated method stub
		formDao.save(form);
	}

	public EvalForm getEvalForm(long id) {
		// TODO Auto-generated method stub
		return formDao.getById(id);
	}

	

}
