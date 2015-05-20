package com.sds.icto.dao.test;

import java.util.List;

import com.sds.icto.dao.MemberDao;
import com.sds.icto.vo.MemberVo;

public class MemberDaoTest {

	private static MemberDao dao;
	
	public static void main(String[] args) {
		before();
		//insertTest();
		getTest();
	}

	public static void before() {
		dao = new MemberDao();
	}
	
	public static void insertTest() {
		MemberVo vo = new MemberVo();
		vo.setName( "test" );
		vo.setEmail( "test@test.com" );
		vo.setPassword( "1234" );
		vo.setGender( "male" );
		
		dao.insert(vo);
	}
	
	public static void getTest() {
		MemberVo vo = new MemberVo();
		vo.setEmail( "test@test.com" );
		vo.setPassword( "1234" );
		
		MemberVo memberVo = dao.get( vo );
		System.out.println( memberVo.getNo() + ":" + memberVo.getName() );
	
		List<MemberVo> list = dao.getByEmail( "kickscar@gmail.com" );
		for( MemberVo o : list ) {
			System.out.println( o.getNo() + ":" + o.getEmail() + ":" + o.getName() );
		}
		
		list = dao.getByNameEmail( "안대혁", "kickscar@gmail.com" );
		for( MemberVo o : list ) {
			System.out.println( o.getNo() + ":" + o.getEmail() + ":" + o.getName() );
		}
		
	}
}
