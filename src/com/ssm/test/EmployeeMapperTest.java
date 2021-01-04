package com.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssm.bean.Employee;
import com.ssm.mapper.EmployeeMapper;

public class EmployeeMapperTest {
	private static final Logger LOGGER = Logger.getLogger(EmployeeMapperTest.class);
	SqlSessionFactory sqlSessionFactory = null;
	InputStream inputStream = null;
	@Before
	public void getFactory() {
		String resource = "mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			//根据配置文件信息创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetEmpById() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		
		//操作数据库
		Employee employee = employeeMapper.getEmpById(1);
		LOGGER.info(employee);
		if (employee != null) LOGGER.info(employee.getDepartment());
	}

	@Test
	public void testGetEmpByIdAndLastName() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		Employee employee = employeeMapper.getEmpByIdAndLastName(1,"mm4");
		LOGGER.info(employee);
	}

	@Test
	public void testGetAllEmps() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		List<Employee> allEmps = employeeMapper.getAllEmps();
		LOGGER.info(allEmps);
	}
	
	@Test
	public void testGetEmpsByIds() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		List<Employee> allEmps = employeeMapper.getEmpsByIds(ids);
		LOGGER.info(allEmps);
	}
	
	@Test
	public void testGetEmpsLikeLastName() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		String lastName = "m";
		List<Employee> allEmps = employeeMapper.getEmpsLikeLastName(lastName);
		LOGGER.info(allEmps);
	}

	@Test
	public void testGetEmpsByConditions() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		Employee paramEmp = new Employee(null, "zzz", "abc@126.com", 1, null, new BigDecimal(1232.34), 1);
		List<Employee> allEmps = employeeMapper.getEmpsByConditions(paramEmp );
		LOGGER.info(allEmps);
	}

	@Test
	public void testGetAllEmpsMap() {
		EmployeeMapper employeeMapper = newEmployeeMapper();
		Map<Integer, Employee> allEmpsMap = employeeMapper.getAllEmpsMap();
		LOGGER.info(allEmpsMap);
	}

	@Test
	public void testUpdateEmployee() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = new Employee(1, "zzz", "abc@126.com", 1, new Date(), new BigDecimal(1232.34),1);
		employeeMapper.updateEmployee(employee);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testAddEmployee() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = new Employee(null, "mmm"+new Random().nextInt(), "mmm4@126.com", 1, new Date(), new BigDecimal(1232.34),1);
		employeeMapper.addEmployee(employee);
		sqlSession.commit();
		sqlSession.close();
		LOGGER.info("mysql自增Id="+employee.getId());
	}
	
	@Test
	public void testAddEmps() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> emps = new ArrayList<Employee>();
		Employee employee = new Employee(null, "mmm"+new Random().nextInt(), "mmm67@126.com", 1, new Date(), new BigDecimal(1232.34),1);
		emps.add(employee);
		employee = new Employee(null, "mmm"+new Random().nextInt(), "mmm56@126.com", 0, new Date(), new BigDecimal(1232.34),1);
		emps.add(employee);
		employeeMapper.addEmps(emps);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteEmployee() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		employeeMapper.deleteEmployee(2);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@After
	public void close() {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private EmployeeMapper newEmployeeMapper() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.getMapper(EmployeeMapper.class);
	}

}
