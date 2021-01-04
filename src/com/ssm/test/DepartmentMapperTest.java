package com.ssm.test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.ssm.bean.Department;
import com.ssm.mapper.DepartmentMapper;

public class DepartmentMapperTest {
	private static final Logger LOGGER = Logger.getLogger(DepartmentMapperTest.class);
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
	public void testGetDeptById() {
		DepartmentMapper departmentMapper = newDepartmentMapper();
		Department dept = departmentMapper.getDeptById(1);
		
		LOGGER.info(dept);
		if (dept != null) LOGGER.info(dept.getEmpList());
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
	
	private DepartmentMapper newDepartmentMapper() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.getMapper(DepartmentMapper.class);
	}

}
