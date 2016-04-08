<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.Iterator,model.Department,model.Employee;"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="department.jsp">Department Record</a><br>

<h2>Employee Record management</h2>
<h3 style="color: red ">${message}</h3>


<table  cellspacing="2" border=3 cellpadding="3"width="500px">

<tr>

<th> Employee Id</th><th>Employee Name</th><th>Department Name</th><th>Action</th>
</tr>

<tr>
<form action="/Employee/jsp/insert.html" method="post" id= "form1">
<td></td>
<td><input type="text" name="ename" /></td>
<td>
<select name="deptid" required>
<option value="default">Select</option>
<%
ArrayList <Department> departmentlst=(ArrayList<Department>)request.getAttribute("departmentlst");
Iterator<Department> i= departmentlst.iterator();

while(i.hasNext() ){
	Department temp =i.next();
	%>
	<option value="<%=temp.getId()%>"><%=temp.getName()%></option>
			<%
	}
%>
</select>
</td>
<td> <input type="submit" value= "insert"></td>
</form>
</tr>
 
 
 
 <% 
 ArrayList <Employee> employeelst=(ArrayList<Employee>)request.getAttribute("employeelst"); 
 Iterator<Employee> e= employeelst.iterator();
 //System.out.println(i.next().getType());
 String temp; 
 while(e.hasNext() ){ 
	 Employee t= e.next(); 
	%> 
   
  <tr> 
  <form action="/Employee/jsp/delete.html" method="post" id= "form1">
 <td><%=t.getId()%><input type="hidden" name="id" value="<%=t.getId()%>" /></td>
 <td><%=t.getName()%></td>
 <td><%=t.getDepartment().getName()%></td>
 <td><input type="submit" value="delete"></td>
</form> 
 </tr> 



 	<% 
	} 
 %> 
 



</table>




 

</body>
</html>