package com.sds.icto.dao.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.sds.icto.dao.BoardDao;
import com.sds.icto.vo.BoardVo;

public class BoardDaoTest {
	private static BoardDao dao;
	public static void before() {
		dao = new BoardDao();
	}
	public static void main(String[] args) {
		before();

		getJoinListTest();
//		insertTest();
		searchTest();
	}
	
	public static void insertTest() {
		BoardVo vo = new BoardVo();
		vo.setTitle( "다오테스트에서 넣은 글" );
		vo.setContent( "잘될겁니다~" );
		vo.setMemberNo( 1L );
		vo.setMemberName( "안대혁" );
		
		Long newNo = dao.insert( vo );
		System.out.println( "새로 들어간 글의 번호(no) : " + newNo );
	}

	public static void searchTest() {
		System.out.println( "======================" );

		List<LinkedHashMap> list = dao.getJoinList(
		"안", "째", "");
		for( LinkedHashMap map : list ) {
			for(  Object o : map.values() ) {
				System.out.print( o );
				System.out.print(  " : " );
			}
			System.out.println( "\n" );
		} 
	}
	
	public static void getJoinListTest() {
		List<LinkedHashMap> list = dao.getJoinList();
		for( LinkedHashMap map : list ) {
			for(  Object o : map.values() ) {
				System.out.print( o );
				System.out.print(  " : " );
			}
			System.out.println( "\n" );
			
		} 
		
	}
}
