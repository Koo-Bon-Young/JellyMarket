package kr.co.ljy.jellyshop.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static final SqlSession sqlMapper;
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlMapper = sqlFactory.openSession(true); //true - 자동커밋, false, 또는 공백 - commit을 직접 해줘야한다.
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}
	//SqlSession = MyAppSqlConfig.getSqlSession();
	public static SqlSession getSqlSession() {
		return sqlMapper;
	}
}