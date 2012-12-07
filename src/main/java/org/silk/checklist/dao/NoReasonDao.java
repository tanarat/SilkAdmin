package org.silk.checklist.dao;

import java.util.List;

import org.silk.checklist.model.NoReason;




public interface NoReasonDao{
	public void save(NoReason reason);
	public List<NoReason> list();
	public void delete(Long id);
	public NoReason getById(Long id);
	public List<NoReason> getByQuestionId(Long questionId);
}
