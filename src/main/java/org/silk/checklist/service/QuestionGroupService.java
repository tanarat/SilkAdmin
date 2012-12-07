package org.silk.checklist.service;

import java.util.List;

import org.silk.checklist.dao.QuestionGroupDao;
import org.silk.checklist.dao.QuestionGroupDaoImpl;
import org.silk.checklist.model.Question;
import org.silk.checklist.model.QuestionGroup;

public class QuestionGroupService {

	private QuestionGroupDao questionGroupDao = new QuestionGroupDaoImpl();
	public List<QuestionGroup> getAllQuestionGroups() {
		// TODO Auto-generated method stub
		return questionGroupDao.list();
	}
	public QuestionGroup getQuestionGroup(Long id){
		return questionGroupDao.listById(id);
	}
	public void deleteQuestionGroup(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void saveQuestionGroup(QuestionGroup questionGroup) {
		// TODO Auto-generated method stub
		questionGroupDao.save(questionGroup);
	}

}
