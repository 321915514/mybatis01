package utils;

import java.io.IOException;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	public static SqlSessionFactory  getSqlSessionFactory(String Re) {
		SqlSessionFactory sqlsessionFactory;
		try {
			sqlsessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(Re));
			return sqlsessionFactory;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
