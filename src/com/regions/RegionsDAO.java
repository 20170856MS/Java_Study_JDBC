package com.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnector;

public class RegionsDAO {
	
	//1. Regions 테이블의 모든 데이터 가져오기
	
	public void getList() throws Exception {
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		
		//2.Query문 작성
		String sql = "SELECT * FROM REGIONS";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.
		
		//5. 최종 전송 후 결과처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("Region_id");
			String name = rs.getString("Region_name");
			System.out.println(id);
			System.out.println(name);
			
		}
		
		
	}
	

}
