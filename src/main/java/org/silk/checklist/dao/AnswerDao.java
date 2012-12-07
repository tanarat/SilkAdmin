package org.silk.checklist.dao;

import java.util.List;

import org.silk.checklist.model.Answer;





public interface AnswerDao{
	public void save(Answer answer);
	public List<Answer> list();
	public void delete(Long id);
	public Answer getById(Long id);
	public Answer getAnswer(Long formId, Long questionId);

}
