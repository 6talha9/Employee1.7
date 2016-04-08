package model;

import java.util.List;

public class Department {
	int id;
	String name;
	List<Employee> employeelst;
	public List<Employee> getEmployeelst() {
		return employeelst;
	}
	public void setEmployeelst(List<Employee> employeelst) {
		this.employeelst = employeelst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
