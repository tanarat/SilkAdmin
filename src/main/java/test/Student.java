package test;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Student {
	@Id
	private Long id;
	private String name;
	@ElementCollection
	@CollectionTable(
	        name="nickname",
	        joinColumns=@JoinColumn(name="student_id")
	)

	private List<String> nickname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getNickname() {
		return nickname;
	}
	public void setNickname(List<String> nickname) {
		this.nickname = nickname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
