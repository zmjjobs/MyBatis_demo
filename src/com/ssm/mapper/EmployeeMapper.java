package com.ssm.mapper;
 
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import com.ssm.bean.Employee;
 
public interface EmployeeMapper {
	Employee getEmpById(Integer id);
	Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	List<Employee> getAllEmps();
	List<Employee> getEmpsByIds(@Param("ids")List<Integer> ids);
	List<Employee> getEmpsLikeLastName(String lastName);
	List<Employee> getEmpsByConditions(Employee paramEmp);
	
	@MapKey("id")
	Map<Integer,Employee> getAllEmpsMap();
	
	int updateEmployee(Employee employee);
	int addEmployee(Employee employee);
	void addEmps(@Param("emps")List<Employee> emps);
	int deleteEmployee(Integer id);
}