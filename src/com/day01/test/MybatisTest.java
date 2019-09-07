package com.day01.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.day01.dao.UserDao;
import com.day01.entity.User;

import utils.SqlSessionFactoryUtil;

public class MybatisTest {
	@Test
	public void test1() throws Exception{
		SqlSessionFactory sessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory("mybatis-config.xml");
		SqlSession session = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		UserDao userDao=session.getMapper(UserDao.class);
		UserDao userDao2=session2.getMapper(UserDao.class);
		try {
			User user=userDao.getUser(23);
			System.out.println(user.toString());
			session.close();
			System.out.println(userDao2.getUser(50));
			System.out.println(userDao2.getUser(23));
			System.out.println(userDao2.getUser(23));
			session2.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
		}
		
		
		
	

		
	}
	@Test
	public void test2() throws Exception{
		SqlSessionFactory sessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory("mybatis-config.xml");
		SqlSession session = sessionFactory.openSession(true);
		UserDao userDao=session.getMapper(UserDao.class);
		try {
			User user = new User();
			user.setUsername("c++");
			user.setPassword("c++");
			user.setSex(true);
			int rows=userDao.addUser(user);
			
			System.out.println(rows);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	@Test
	public void test3() throws Exception{
		SqlSessionFactory sessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory("mybatis-config.xml");
		SqlSession session = sessionFactory.openSession(true);
		UserDao userDao=session.getMapper(UserDao.class);
		try {
			List<User> list=userDao.findAll();
			
			for (User user : list) {
				System.out.println(user.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	@Test
	public void test4() throws Exception{
		SqlSessionFactory sessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory("mybatis-config.xml");
		SqlSession session = sessionFactory.openSession(true);
		UserDao userDao=session.getMapper(UserDao.class);
		try {
			Map<Integer, User> map=userDao.findByMap();
			Set<Entry<Integer,User>> entrySet = map.entrySet();
			for (Entry<Integer, User> entry : entrySet) {
				System.out.println(entry.getKey()+"----"+entry.getValue());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	@Test
	public void test5() throws Exception{
		SqlSessionFactory sessionFactory=SqlSessionFactoryUtil.getSqlSessionFactory("mybatis-config.xml");
		SqlSession session = sessionFactory.openSession(true);
		UserDao userDao=session.getMapper(UserDao.class);
		try {
			
			
			User user = new User();
			user.setId(4);
			user.setUsername("%h%");
			/*user.setSex(true);*/
			List<User> list=userDao.findBydongtai(user);
			for (User user2 : list) {
				System.out.println(user2.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		
	}
	
	
	

}
