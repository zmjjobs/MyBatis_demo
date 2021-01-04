package com.ssm.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Employee implements Serializable {
	private static final long serialVersionUID = 2231616471444612551L;
	private Integer id;
	private String lastName;
	private String email;
	
	/** 1 - male   0 - female */
	private Integer gender;
	private Date birthday;
	private BigDecimal salary;
	private Integer deptId;
	private Department department;
	
	public Employee() {
	}
	
	public Employee(Integer id, String lastName, String email, Integer gender,
			Date birthday, BigDecimal salary, Integer deptId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.salary = salary;
		this.deptId = deptId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", birthday=" + birthday
				+ ", salary=" + salary + ", deptId=" + deptId + "]";
	}
	
}
