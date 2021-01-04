package com.ssm.bean;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
	
	private static final long serialVersionUID = 6693376322085236670L;
	private Integer id ;
	private String deptName;
	private List<Employee> empList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}
	
}
