package cn.manage.pojo;

public class Employee {

	private Integer id;
	private String name;
	private String mail;
	private Integer gender;
	private Department dept;
	
	public Employee() {
	}

	public Employee(Integer id, String name, String mail, Integer gender, Department dept) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
