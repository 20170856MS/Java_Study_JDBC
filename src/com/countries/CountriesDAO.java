package com.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnector;

public class CountriesDAO {

	
	public void getList() throws Exception {
		//1.DB 연결
				Connection con = DBConnector.getConnection();
				
				//2.Query문 작성
				String sql = "SELECT * FROM COUNTRIES";
				
				//3. Query문 미리 전송
				PreparedStatement st = con.prepareStatement(sql);
				
				//4.
				
				//5. 최종 전송 후 결과처리
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					String cid = rs.getString("COUNTRY_ID");
					String name = rs.getString("COUNTRY_NAME");
					int id = rs.getInt("Region_ID");
					System.out.print(cid+" ");
					System.out.print(name+" ");
					System.out.print(id);
					System.out.println("");
					
				}
	}
}
