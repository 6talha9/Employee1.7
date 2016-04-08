package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveEmployee(Employee i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	
	    @Transactional(readOnly=false)
	    public Boolean deleteEmployeeById(int id){  
	    	Employee e= getById(id);
	    	if(e!=null){
	    	template.delete(e);
	    	return true;
	    	}else{
	    		return false;
	    	}  
	    }
	    public Employee getById(int id){  
	    	Employee i=(Employee)template.get(Employee.class,id);  
	        return i;  
	    }  
	    
	
	    
		public List<Employee> getEmployees(){  
	        List<Employee> list=new ArrayList<Employee>();  
	        list=template.loadAll(Employee.class);
	        
	        return list;  
	        
	    } 
	
}
