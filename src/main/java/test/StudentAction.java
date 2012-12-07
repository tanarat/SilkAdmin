package test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student = new Student();
	private List<Student> studentList = new ArrayList<Student>();
	
	
	private StudentDaoImpl dao = new StudentDaoImpl();
	
	

	
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	public String save(){
		return SUCCESS;
	}
	public String list(){
		studentList = dao.list();
		return SUCCESS;
	}
	public String delete(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.delete(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	/*
	 * To get single record by Id
	 */
	public String edit(){
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String id = request.getParameter("id");
		if(id!=null){
			student = dao.listById(Long.parseLong(request.getParameter("id")));
			
		}else{
			student = new Student();
		}
		
		return SUCCESS;
	}
	public Student getQuestion() {
		return student;
	}

	public void setQuestion(Student question) {
		this.student = question;
	}

	public List<Student> getQuestionList() {
		return studentList;
	}
	public void setQuestionList(List<Student> questionList) {
		this.studentList = questionList;
	}



	



}
