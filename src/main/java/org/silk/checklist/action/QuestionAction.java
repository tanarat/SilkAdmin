package org.silk.checklist.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.silk.checklist.model.Question;
import org.silk.checklist.model.QuestionGroup;
import org.silk.checklist.service.QuestionGroupService;
import org.silk.checklist.service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionAction extends ActionSupport implements ModelDriven<Question>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tag = this.getClass().getName();
	private Log logger = LogFactory.getLog(this.getClass());
	private static QuestionService questionService = new QuestionService();
	private static QuestionGroupService questionGroupService = new QuestionGroupService();
//	private static NoReasonService noReasonService = new NoReasonService();
	
	private Question question;
	private List<Question> questions;

	
	
	private List<QuestionGroup> questionGroups;// = new ArrayList<QuestionGroup>();
	
	public Question getModel() {
		// TODO Auto-generated method stub
		return question;
	}
	
	public String doSave(){
		logger.info(tag + ":doSave()");
		System.out.println("do save..");
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String groupIdSelected = request.getParameter("groupIdSelected");
		QuestionGroup groupSelected = questionGroupService.getQuestionGroup(Long.parseLong(groupIdSelected));
		
		question.setQuestionGroup(groupSelected);
		questionService.saveQuestion(question);
		return SUCCESS;
	}
	public String doList(){
		logger.info(tag + ":doList()");
		questions = questionService.getAllQuestions();
		return SUCCESS;
	}
	public String doDelete(){
		logger.info(tag + ":doDelete()");
		questionService.deleteQuestion(question.getId());
		return SUCCESS;
	}
	public String edit(){
		logger.info(tag + ":doInput()");
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String questionId = request.getParameter("questionId");
		System.out.println("questionId : " + questionId);
		if(questionId!=null){
			question = questionService.getQuestion(Long.parseLong(questionId));
		}

		return INPUT;
	}
	public String addNoList(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String questionId = request.getParameter("questionId");

		if(questionId!=null){
			question = questionService.getQuestion(Long.parseLong(questionId));
			questionService.saveQuestion(question);
		}

		return SUCCESS;
	}
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questionList) {
		this.questions = questionList;
	}

	public List<QuestionGroup> getQuestionGroups() {
		questionGroups = questionGroupService.getAllQuestionGroups();
		return questionGroups;
	}

	public void setQuestionGroups(List<QuestionGroup> questionGroups) {
		this.questionGroups = questionGroups;
	}

	
	

	


}
