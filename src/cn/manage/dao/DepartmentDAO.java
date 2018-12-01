package cn.manage.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import cn.manage.pojo.Department;

public class DepartmentDAO {

	//模拟数据库
	private static Map<Integer,Department> depts;
	static {
		depts =  new HashMap<Integer,Department>();
		depts.put(1,new Department(1,"SALES"));
		depts.put(2,new Department(2,"HR"));
	}
	//获取所有部门
	public static Collection<Department> getAllDepts() {
		return depts.values();
	}
	
	public static Department getDeptById(Integer id) {
		return depts.get(id);
	}
	
}
