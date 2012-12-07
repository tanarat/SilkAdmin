package org.silk.checklist.service;

import java.util.List;
import java.util.Set;

import org.silk.checklist.dao.QuestionDao;
import org.silk.checklist.dao.QuestionDaoImpl;
import org.silk.checklist.model.Question;

public class QuestionService {
	private QuestionDao questionDao = new QuestionDaoImpl();
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.list();
	}

	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
	}

	public Question getQuestion(long questionId) {
		// TODO Auto-generated method stub
		return questionDao.getById(questionId);
	}

	public List<Question> getQuestions(Set<Long> questionIdSet) {
		// TODO Auto-generated method stub
		return questionDao.getByIds(questionIdSet);
	}

}
