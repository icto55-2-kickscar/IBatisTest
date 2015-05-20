package com.sds.icto.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.vo.EmailListVo;

public class EmailListDao {

	private SqlMapClient sqlMapClient;

	public EmailListDao() {
		try {
			Reader reader = Resources.getResourceAsReader( "SqlMapConfig.xml" );
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			sqlMapClient.delete( "emaillist.deleteAll" );
		} catch( SQLException ex ) {
			ex.printStackTrace();
		}
	}
	
	public void insert( EmailListVo vo ) {
		try {
			sqlMapClient.insert( "emaillist.insert", vo );
		} catch( SQLException ex ) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmailListVo> getList() {
		List<EmailListVo> list = null;
		
		try {
			list = sqlMapClient.queryForList( "emaillist.list" );
		} catch( SQLException ex ) {
			ex.printStackTrace();
		}
		
		return list;
	}

}