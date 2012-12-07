package org.silk.checklist.dao; 

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.Answer;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class AnswerDaoImpl implements AnswerDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(Answer answer) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(answer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> list() {
		// TODO Auto-generated method stub
		System.out.println("list all Answers");
		return session.createQuery("from Answer").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Answer getById(Long id) {
		// TODO Auto-generated method stub
		Answer answer = new Answer();
		answer = (Answer)session.get(Answer.class, id);
		return answer;
	}

	@Override
	public Answer getAnswer(Long formId, Long questionId) {
		// TODO Auto-generated method stub
		System.out.println("=======================");
		System.out.println("formId : " + formId);
		System.out.println("questionId : " + questionId);
		String hql = "from Answer a where a.form = :evalFormId and a.question = :questionId";
		return (Answer) session.createQuery(hql)
						.setParameter("formId", formId)
						.setParameter("questionId", questionId)
						.list();
		
	}


	

}
