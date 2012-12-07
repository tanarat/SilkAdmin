package org.silk.checklist.dao;

import java.util.List;

import org.silk.checklist.model.QuestionGroup;
import org.silk.common.model.HalalProduct;



public interface QuestionGroupDao{
	public void save(QuestionGroup qGroup);
	public List<QuestionGroup> list();
	public void delete(Long id);
	public QuestionGroup listById(Long id);
}
