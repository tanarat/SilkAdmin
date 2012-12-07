package org.silk.checklist.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.checklist.model.Answer;
import org.silk.checklist.service.AnswerService;
import org.silk.checklist.service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Answer answer;
	
	
	private AnswerService answerService = new AnswerService();
	private QuestionService questionService = new QuestionService();

	

	
	
	public String doSave(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		
		return SUCCESS;
	}
	public String doList(){
		
		
		return SUCCESS;
	}
	public String doDelete(){
		
		return SUCCESS;
	}
	public String doInput(){

		return INPUT;
	}
	public String edit(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String formId = request.getParameter("formId");
		System.out.println("edit......");
		System.out.println("Form id : " + formId);
		String questionId = request.getParameter("questionId");
		System.out.println("Question id : " + questionId);
		
		if(formId != null && questionId != null){
			answer = answerService.getAnswer(Long.parseLong(formId), Long.parseLong(questionId));
		}else{
			answer = new Answer();
		}
		
		return INPUT;
	}
	
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer checklist) {
		this.answer = checklist;
	}
	
	
}
