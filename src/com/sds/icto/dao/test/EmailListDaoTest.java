package com.sds.icto.dao.test;

import java.util.List;

import com.sds.icto.dao.EmailListDao;
import com.sds.icto.vo.EmailListVo;

public class EmailListDaoTest {

	private static EmailListDao dao;
	
	public static void main(String[] args) {
		before();
		
		testInsert();
		testList();
	}
	
	public static void before() {
		dao = new EmailListDao();
		dao.delete();
	}
	
	public static void testInsert() {
		EmailListVo vo = new EmailListVo();
		
		vo.setFirstName( "대혁" );
		vo.setLastName( "안" );
		vo.setEmail( "kickscar@gmail.com" );
		
		dao.insert(vo);

		vo.setFirstName( "대혁2" );
		vo.setLastName( "안" );
		vo.setEmail( "kickscar@sunnyvale.co.kr" );
		
		dao.insert(vo);
	}
	
	public static void testList() {
		List<EmailListVo> list = dao.getList();
		for( EmailListVo vo : list ) {
			System.out.println( vo.getNo() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getEmail() );
		}
	}
	

}
