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
				
				//6. 자원해제
				DBConnector.disConect(rs, st, con);
	}
	//2. 
	public void getDetail(String countries_id) throws Exception{
		CountriesDTO countriesDTO = null;
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		//2.Query문 작성
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?값 세팅
		// WHERE NUM BETEEN ?(1) AND ?(2);
		st.setString(1, countries_id);
		//5. 최종 전송후 결과처리
		ResultSet rs = st.executeQuery();
			
		if(rs.next()) {
			
			countriesDTO = new CountriesDTO();
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			countriesDTO.setCountry_id(rs.getInt("country_id"));
			String cName = rs.getString(2);
			String cId = rs.getString(1);
			
		}
		//6. 자원해제
		DBConnector.disConect(rs, st, con);
		
	}

}
