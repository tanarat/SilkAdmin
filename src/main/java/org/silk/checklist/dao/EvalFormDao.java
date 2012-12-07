package org.silk.checklist.dao;

import java.util.List;


import org.silk.checklist.model.EvalForm;





public interface EvalFormDao{
	public void save(EvalForm form);
	public List<EvalForm> list();
	public void delete(Long id);
	public EvalForm getById(Long id);

}
