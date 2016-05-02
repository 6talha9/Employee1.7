package main.java.cntrlr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.model.Department;
import main.java.model.DepartmentDao;
import main.java.model.EmployeeDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller("spring")
@Controller()
public class DepartmnetCntrlr {
	static String message;

	@RequestMapping("/jsp/deptinsert")
	public ModelAndView deptinsert(HttpServletRequest request, HttpServletResponse res) {
		ApplicationContext r = new ClassPathXmlApplicationContext("applicationContext.xml");

		DepartmentDao departmentDao = (DepartmentDao) r.getBean("DepartmentDao");
		// EmployeeDao employeeDao = (EmployeeDao) r.getBean("EmployeeDao");
		// String id= request.getParameter("id");

		String name = request.getParameter("name");
		Department dpt = new Department();
		// dpt.setId(Integer.parseInt(id));
		dpt.setName(name);
		departmentDao.saveDepartment(dpt);
		message = "Record inserted";
		return new ModelAndView("department", "message", message);
	}
}
