package cn.manage.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.manage.pojo.Employee;

public class EmployeeDAO {
	//模拟数据库
	private static Map<Integer,Employee> emps;
	static {
		emps =  new HashMap<Integer,Employee>();
		emps.put(101,new Employee(101,"AA","AA@QQ.COM",0,DepartmentDAO.getDeptById(2)));
		emps.put(102,new Employee(102,"BB","BB@QQ.COM",0,DepartmentDAO.getDeptById(1)));
		emps.put(103,new Employee(103,"CC","CC@QQ.COM",1,DepartmentDAO.getDeptById(1)));
		emps.put(104,new Employee(104,"DD","DD@QQ.COM",1,DepartmentDAO.getDeptById(2)));
		emps.put(105,new Employee(105,"EE","EE@QQ.COM",0,DepartmentDAO.getDeptById(2)));
	}

	//获取所有员工
	public static Collection<Employee> getAllEmps(){
		return emps.values();
	}
	
	private static Integer key = 106;
	public static void save(Employee emp) {
		emp.setId(key);
		emp.setDept(DepartmentDAO.getDeptById(emp.getDept().getDeptId()));
		emps.put(key ++,emp);
	}
	
	public static void delete(Integer id) {
		emps.remove(id);
	}

	public static Employee getEmployeeById(Integer id) {
		return emps.get(id);
	}
	
	public static void update(Integer id,Employee emp) {
		emp.setDept(DepartmentDAO.getDeptById(emp.getDept().getDeptId()));
		emps.put(id,emp);
	}
	
	
}
