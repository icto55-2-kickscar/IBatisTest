package com.sds.icto.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.vo.BoardVo;

public class BoardDao {
	
	private SqlMapClient sqlMapClient;
	
	public BoardDao() {
		try {
			Reader reader = Resources.getResourceAsReader( "SqlMapConfig.xml" );
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Long insert( BoardVo vo ) {
		Long no = -1L;
		
		try {
			no = (Long)sqlMapClient.insert( "board.insert", vo );
		} catch( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		
		return no;
	}

	@SuppressWarnings("unchecked")
	public List<LinkedHashMap> getJoinList( String name, String title, String content ) {
		List<LinkedHashMap> list = null;
		try {
			Map<String, String> mapKeyword = new HashMap();
			mapKeyword.put( "name", name );
			mapKeyword.put( "title", title );
			mapKeyword.put( "content", content );
			
			list = sqlMapClient.queryForList( "board.search", mapKeyword );
		} catch( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public List<LinkedHashMap> getJoinList() {
		List<LinkedHashMap> list = null;
		try {
			list = sqlMapClient.queryForList( "board.joinlist" );
		} catch( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		return list;
	}
}
