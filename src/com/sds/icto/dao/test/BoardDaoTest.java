package com.sds.icto.dao.test;

import java.util.LinkedHashMap;
import java.util.List;

import com.sds.icto.dao.BoardDao;
import com.sds.icto.vo.BoardVo;

public class BoardDaoTest {
	private static BoardDao dao;
	
	public static void main(String[] args) {
		before();
		
		insertTest();
		getJoinListTest();
		
		searchTest();
	}
	
	public static void before() {
		dao = new BoardDao();
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
		
		System.out.println( "============================검색" );
		
		List<LinkedHashMap> list = dao.getJoinList( "안", "다오", "잘" );
		
		for( LinkedHashMap map : list ) {
			
			for( Object value : map.values() ) {
				System.out.print( value );
				System.out.print( " : " );
			}
			
			System.out.print( "\n" );
		}
	}
	
	public static void getJoinListTest() {
		List<LinkedHashMap> list = dao.getJoinList();
		
		for( LinkedHashMap map : list ) {
			
			for( Object value : map.values() ) {
				System.out.print( value );
				System.out.print( " : " );
			}
			
			System.out.print( "\n" );
		}
	}
}
