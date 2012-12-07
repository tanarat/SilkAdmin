package org.silk.checklist.dao; 

import java.util.List;
import java.util.Set;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.silk.checklist.model.Question;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class QuestionDaoImpl implements QuestionDao {
	@SessionTarget
	Session session;
 
	@TransactionTarget
	Transaction transaction;
	@Override
	public void save(Question question) {
		// TODO Auto-generated method stub
		session.saveOrUpdate(question);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> list() {
		// TODO Auto-generated method stub
		System.out.println("list all questions");
		return session.createQuery("from Question").list();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Question getById(Long id) {
		// TODO Auto-generated method stub
		Question question = new Question();
		question = (Question)session.get(Question.class, id);
		return question;
	}

	@Override
	public List<Question> getByIds(Set<Long> questionIdSet) {
		// TODO Auto-generated method stub
		String hql = "from Question q where q.id IN (:list)";
		return session.createQuery(hql).setParameterList("list", questionIdSet).list();
		
	}

	

}
