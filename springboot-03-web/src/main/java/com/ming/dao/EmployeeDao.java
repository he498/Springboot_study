package com.ming.dao;


import com.ming.pojo.Department;
import com.ming.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"AA","A11166668@qq.com",1,new Department(101,"后勤部")));
        employees.put(1002,new Employee(1002,"BB","B11166668@qq.com",0,new Department(102,"研发部")));
        employees.put(1003,new Employee(1003,"CC","C11166668@qq.com",1,new Department(103,"市场部")));
        employees.put(1004,new Employee(1004,"DD","D11166668@qq.com",0,new Department(104,"后勤部")));
        employees.put(1005,new Employee(1005,"EE","E11166668@qq.com",1,new Department(105,"运营部")));
    }

    //增加一个员工
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    // 通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
