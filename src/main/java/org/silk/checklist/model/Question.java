package org.silk.checklist.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="QUESTION_TITLE")
	private String questionTitle;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private QuestionGroup questionGroup;
	

	@OneToMany(mappedBy = "question")
	private List<NoReason> noList;
	
	public Question(){

	}
	
	
	@Override
	public String toString() {
		return questionTitle + "["+ questionGroup + "]";
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionTitle() {
		
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		System.out.println("set question title " + questionTitle);
		this.questionTitle = questionTitle;
	}
	public QuestionGroup getQuestionGroup() {
		return questionGroup;
	}
	public void setQuestionGroup(QuestionGroup questionGroup) {
		this.questionGroup = questionGroup;
	}


	public List<NoReason> getNoList() {
		return noList;
	}


	public void setNoList(List<NoReason> noList) {
		this.noList = noList;
	}


	
	
	
}
