package org.silk.checklist.model;

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
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	

	@ManyToOne(cascade=CascadeType.ALL)
	private EvalForm evalForm;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Question question;
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name="CHOICE_SELECTED")
	private int choiceSelected;
	
	@Column(name="REMARK")
	private String remark;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ANSWER_NOREASON", joinColumns = { 
			@JoinColumn(name = "ANSWER_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "NOREASON_ID", 
					nullable = false, updatable = false) })
	private List<NoReason> noReasons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EvalForm getEvalForm() {
		return evalForm;
	}

	public void setEvalForm(EvalForm form) {
		this.evalForm = form;
	}

	public int getChoiceSelected() {
		return choiceSelected;
	}

	public void setChoiceSelected(int choiceSelected) {
		this.choiceSelected = choiceSelected;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<NoReason> getNoReasons() {
		return noReasons;
	}

	public void setNoReasons(List<NoReason> noReasons) {
		this.noReasons = noReasons;
	}
	
	
}
