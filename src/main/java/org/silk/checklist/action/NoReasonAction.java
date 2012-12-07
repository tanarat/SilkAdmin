package org.silk.checklist.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.checklist.model.NoReason;
import org.silk.checklist.model.Question;
import org.silk.checklist.service.NoReasonService;
import org.silk.checklist.service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoReasonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NoReason noReason;
	private List<NoReason> noReasons; 
	
	private NoReasonService noReasonService = new NoReasonService();
	private QuestionService questionService = new QuestionService();

	private List<Question> questionList;

	
	public String doSave(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String questionIdSelected = request.getParameter("questionIdSelected");
		Question question = questionService.getQuestion(Long.parseLong(questionIdSelected));
		noReason.setQuestion(question);
		noReasonService.saveNoReason(noReason);
		return SUCCESS;
	}
	public String doList(){
		noReasons = noReasonService.getAllNoReasons();
		return SUCCESS;
	}
	public String doDelete(){
		noReasonService.deleteNoReason(noReason.getId());
		return SUCCESS;
	}
	public String doInput(){

		return INPUT;
	}
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String reasonId = request.getParameter("reasonId");
		if(reasonId!=null){
			noReason = noReasonService.getNoReason(Long.parseLong(reasonId));
		}
		return INPUT;
	}
	public NoReason getNoReason() {
		return noReason;
	}
	public void setNoReason(NoReason noReason) {
		this.noReason = noReason;
	}
	public List<NoReason> getNoReasons() {
		return noReasons;
	}
	public void setNoReasons(List<NoReason> noReasons) {
		this.noReasons = noReasons;
	}
	public List<Question> getQuestionList() {
		questionList = questionService.getAllQuestions();
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	

}
