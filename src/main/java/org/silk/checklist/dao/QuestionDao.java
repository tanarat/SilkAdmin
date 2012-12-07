package org.silk.checklist.dao;

import java.util.List;
import java.util.Set;

import org.silk.checklist.model.Question;



public interface QuestionDao{
	public void save(Question question);
	public List<Question> list();
	public void delete(Long id);
	public Question getById(Long id);
	public List<Question> getByIds(Set<Long> questionIdSet);
}
