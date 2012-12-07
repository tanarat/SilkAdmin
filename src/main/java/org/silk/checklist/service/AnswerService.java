package org.silk.checklist.service;

import java.util.List;

import org.silk.checklist.dao.AnswerDao;
import org.silk.checklist.dao.AnswerDaoImpl;
import org.silk.checklist.model.Answer;

public class AnswerService {
	private AnswerDao answerDao = new AnswerDaoImpl();
	public List<Answer> getAllAnswers() {
		// TODO Auto-generated method stub
		return answerDao.list();
	}

	public void deleteAnswer(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveAnswer(Answer answer) {
		// TODO Auto-generated method stub
		answerDao.save(answer);
	}

	public Answer getAnswer(long id) {
		// TODO Auto-generated method stub
		return answerDao.getById(id);
	}

	public Answer getAnswer(Long formId, Long questionId) {
		// TODO Auto-generated method stub
		return answerDao.getAnswer(formId, questionId);
	}

	

}
