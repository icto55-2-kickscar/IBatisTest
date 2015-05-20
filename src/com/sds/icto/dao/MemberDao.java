package com.sds.icto.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.vo.MemberVo;

public class MemberDao {
	
	private SqlMapClient sqlMapClient;
	
	public MemberDao() {
		try {
			Reader reader = Resources.getResourceAsReader( "SqlMapConfig.xml" );
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public List<MemberVo> getByNameEmail( 
			String name, 
			String email  ) {
		List<MemberVo> list = null;

		try {
			Map map = new HashMap();
			map.put( "n", name );
			map.put( "e", email );
			
			list = sqlMapClient.queryForList( 
					"member.getMember3", map );
		} catch ( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		
		return list;
	}
	
	
	public List<MemberVo> getByEmail( String email ) {
		List<MemberVo> list = null;

		try {
		list = sqlMapClient.queryForList( 
				"member.getMember2", email );
		
		} catch ( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		
		return list;
	}

	public MemberVo get( MemberVo vo ) {
		MemberVo memberVo = null;
		try {
			memberVo = ( MemberVo ) 
		sqlMapClient.queryForObject( "member.getMember", vo );
		} catch( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
		
		return memberVo;
	}
	
	public void insert( MemberVo vo ) {
		try {
			sqlMapClient.insert( "member.insert", vo );
		} catch( SQLException ex ) {
			throw new RuntimeException( ex.getMessage() );
		}
	}
}
