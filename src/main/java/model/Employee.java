package main.java.model;

public class Employee {
int id;
String name;
Department department;
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
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
