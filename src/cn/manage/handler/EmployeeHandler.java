package cn.manage.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.manage.dao.DepartmentDAO;
import cn.manage.dao.EmployeeDAO;
import cn.manage.pojo.Employee;

@Controller
public class EmployeeHandler {

	private final String SUCCESS = "success";
	private final String INPUT = "input";
	@RequestMapping(value="/allEmps",method=RequestMethod.GET)
	public String allEmps(Map<String,Object> map) {
		map.put("emps",EmployeeDAO.getAllEmps());
		return SUCCESS;
	}
	
	@RequestMapping(value="/input/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id,Map<String,Object> map) {
		//获取所有的性别和部门信息
		Map<Integer,Object> genders = new HashMap<Integer,Object>();
		genders.put(0,"MALE");
		genders.put(1,"FEMALE");
		map.put("genders",genders);
		map.put("depts",DepartmentDAO.getAllDepts());
		Employee e = new Employee();
		if(id != 0) {
			e = EmployeeDAO.getEmployeeById(id);
		}
		map.put("command",e);
		return INPUT;
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String add(Employee emp) {
		EmployeeDAO.save(emp);
		return "redirect:/allEmps";
	}
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		EmployeeDAO.delete(id);
		return "redirect:/allEmps";
	}
	
	@ModelAttribute
	public void attri(Integer id,Map<String,Object> map) {
		if(id != null) {
			Employee emp = EmployeeDAO.getEmployeeById(id);
			map.put("employee",emp);
		}
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee emp) {
		EmployeeDAO.update(emp.getId(), emp);
		return "redirect://allEmps";
	}
	
	
}
