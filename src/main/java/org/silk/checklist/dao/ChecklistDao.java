package org.silk.checklist.dao;

import java.util.List;

import org.silk.checklist.model.Checklist;





public interface ChecklistDao{
	public void save(Checklist checklist);
	public List<Checklist> list();
	public void delete(Long id);
	public Checklist getById(Long id);

}
