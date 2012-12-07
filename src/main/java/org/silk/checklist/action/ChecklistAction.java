package org.silk.checklist.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.silk.checklist.model.Checklist;
import org.silk.checklist.model.Question;
import org.silk.checklist.service.ChecklistService;
import org.silk.checklist.service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChecklistAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Checklist checklist;
	private List<Checklist> checklists; 
	
	private ChecklistService checklistService = new ChecklistService();
	private QuestionService questionService = new QuestionService();

	private List<Question> questionList;

	
	
	public String doSave(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String[] questionCheck = request.getParameterValues("questionCheck");
		System.out.println(Arrays.toString(questionCheck));
		Set<Long> questionIdSet = new HashSet<Long>();
		for (int j = 0; j < questionCheck.length; j++) {
			questionIdSet.add(Long.parseLong(questionCheck[j]));
		}
		System.out.println(questionIdSet);
		List<Question> questionCheckList = questionService.getQuestions(questionIdSet);
		System.out.println(questionCheckList);
		checklist.setQuestions(questionCheckList);
//		Question question = questionService.getQuestion(Long.parseLong(questionIdSelected));

		checklistService.saveChecklist(checklist);
		
		
		return SUCCESS;
	}
	public String doList(){
		checklists = checklistService.getAllChecklists();
		
		return SUCCESS;
	}
	public String doDelete(){
		checklistService.deleteChecklist(checklist.getId());
		return SUCCESS;
	}
	public String doInput(){

		return INPUT;
	}
	public String edit(){
		
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String checklistId = request.getParameter("checklistId");
		if(checklistId!=null){
			checklist = checklistService.getChecklist(Long.parseLong(checklistId));
			System.out.println("list ... " + checklist.getQuestions());
		}
		
		return INPUT;
	}
	
	public Checklist getChecklist() {
		return checklist;
	}
	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}
	public List<Checklist> getChecklists() {
		return checklists;
	}
	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}
	public List<Question> getQuestionList() {
		questionList = questionService.getAllQuestions();
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Long> getTmp(){
		List<Long> tmp = new ArrayList<Long>();
		tmp.add(1L); tmp.add(2L); tmp.add(3L); tmp.add(17L);
		return tmp;
	}
	

}
