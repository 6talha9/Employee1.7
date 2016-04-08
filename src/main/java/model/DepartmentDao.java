package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DepartmentDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveDepartment(Department i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	
	
	    public void deleteDepartments(Department i){  
	        template.delete(i);  
	    }  
	    
	    public Department getById(int id){  
	    	Department i=(Department)template.get(Department.class,id);  
	        return i;  
	    }  
	    
	
	    
		public List<Department> getDepartments(){  
	        List<Department> list=new ArrayList<Department>();  
	        list=template.loadAll(Department.class);  
	        return list;  
	        
	    } 
	
}
