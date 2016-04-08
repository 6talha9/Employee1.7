package cntrlr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Department;
import model.DepartmentDao;

import model.Employee;
import model.EmployeeDao;


//import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller()
public class HomeCntrlr {
	//static String message;
	
		@RequestMapping("/jsp/home.html")
		public ModelAndView home(HttpServletRequest request,
				HttpServletResponse res) {
			ApplicationContext r = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			
			String message;
			
	DepartmentDao departmentDao= (DepartmentDao) r.getBean("DepartmentDao");
			EmployeeDao employeeDao = (EmployeeDao) r.getBean("EmployeeDao");
			List<Employee> employeelst=employeeDao.getEmployees();
			List<Department> departmentlst=departmentDao.getDepartments();
			//message = "Welcome " + name;
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("employeelst", employeelst);
			modelAndView.addObject("departmentlst", departmentlst);

			modelAndView.setViewName("home");// do this here if problem

			// request.getRequestDispatcher("home.jsp").forward(request,res);
			return modelAndView;
			//return new ModelAndView("user/transaction", "emplst", employeelst);
		}
		
		@RequestMapping("/jsp/insert")
		public ModelAndView insert(HttpServletRequest request,
				HttpServletResponse res ) throws IOException {
			ApplicationContext r = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			String message;
			
			
DepartmentDao departmentDao= (DepartmentDao) r.getBean("DepartmentDao");
			EmployeeDao employeeDao = (EmployeeDao) r.getBean("EmployeeDao");
	//String id= request.getParameter("id");
		
			String name= request.getParameter("ename");
			String deptid= request.getParameter("deptid");
		
			Employee emp=new Employee();
			//emp.setId(Integer.parseInt(id));
			emp.setName(name);
			Department dpt=new Department();
			dpt.setId(Integer.parseInt(deptid));
			emp.setDepartment(dpt);
			System.out.println("ooooooooooo");
			employeeDao.saveEmployee(emp);
			
			List<Employee> employeelst=employeeDao.getEmployees();
			List<Department> departmentlst=departmentDao.getDepartments();
			message= "Record is successfully inserted";
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("employeelst", employeelst);
			modelAndView.addObject("departmentlst", departmentlst);
			modelAndView.addObject("message", message);
			modelAndView.setViewName("home");
			return modelAndView;
			//System.out.println("ooooooooooo22222222222");
			
			//System.out.println("ooooooooooo33333333333");
			
			
			
			
			//home(request,res);
		/*	request.
			PrintWriter out = res.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('User Name or Password incorrect, Try Again.');");
			   			   out.println("</script>");
			   			   res.sendRedirect("//localhost:8080/Employee/jsp/home.html");*/
		}
		
		@RequestMapping("/jsp/delete")
		public ModelAndView delete(HttpServletRequest request,
				HttpServletResponse res) {
			ApplicationContext r = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			String message;
			String id= request.getParameter("id");

			EmployeeDao employeeDao = (EmployeeDao) r.getBean("EmployeeDao");
			if(employeeDao.deleteEmployeeById(Integer.parseInt(id))){
			message= "Record is successfully Deleted";
				//return new ModelAndView("home", "message", message);
				home(request,res);
			}else{
				message= "Record is not there to delete";
				//return new ModelAndView("home", "message", message);
				home(request,res);
				
			}
			
			
			DepartmentDao departmentDao= (DepartmentDao) r.getBean("DepartmentDao");
			List<Employee> employeelst=employeeDao.getEmployees();
			List<Department> departmentlst=departmentDao.getDepartments();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("employeelst", employeelst);
			modelAndView.addObject("departmentlst", departmentlst);
			modelAndView.addObject("message", message);
			modelAndView.setViewName("home");
			return modelAndView;
	
			
			
		}
		

}
