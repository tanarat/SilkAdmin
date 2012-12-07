package org.silk.checklist.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Checklist {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="CHECKLIST_NAME")
	private String checklistName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CHECKLIST_QUESTION", joinColumns = { 
			@JoinColumn(name = "CHECKLIST_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "QUESTION_ID", 
					nullable = false, updatable = false) })
	private List<Question> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChecklistName() {
		return checklistName;
	}

	public void setChecklistName(String checklistName) {
		this.checklistName = checklistName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	@Transient
	public int getNumberOfQuestions(){
		return questions.size();
	}
	
	public List<Long> getListOfQuestionIds(){
		List<Long> arr = new ArrayList<Long>();
		for (int i = 0; i < questions.size(); i++) {
			arr.add(questions.get(i).getId());
		}
		System.out.println("arr " + arr);
		return arr;
	}
}
