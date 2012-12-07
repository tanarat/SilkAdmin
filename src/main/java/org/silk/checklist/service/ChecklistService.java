package org.silk.checklist.service;

import java.util.List;

import org.silk.checklist.dao.ChecklistDao;
import org.silk.checklist.dao.ChecklistDaoImpl;
import org.silk.checklist.model.Checklist;

public class ChecklistService {
	private ChecklistDao checklistDao = new ChecklistDaoImpl();
	public List<Checklist> getAllChecklists() {
		// TODO Auto-generated method stub
		return checklistDao.list();
	}

	public void deleteChecklist(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveChecklist(Checklist reason) {
		// TODO Auto-generated method stub
		checklistDao.save(reason);
	}

	public Checklist getChecklist(long id) {
		// TODO Auto-generated method stub
		return checklistDao.getById(id);
	}

	

}
