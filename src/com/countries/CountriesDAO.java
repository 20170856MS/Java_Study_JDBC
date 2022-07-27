package com.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnector;

public class CountriesDAO {

	
	public ArrayList<CountriesDTO> getList() throws Exception {
		//1.DB 연결
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		Connection con = DBConnector.getConnection();
				
		//2.Query문 작성
		String sql = "SELECT * FROM COUNTRIES";
				
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.
		
		//5. 최종 전송 후 결과처리
		ResultSet rs = st.executeQuery();
				
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			String cid = rs.getString("COUNTRY_ID");
			ar.add(countriesDTO);
			
		}
		
		//6. 자원해제
		DBConnector.disConect(rs, st, con);
		return ar;
	}
	//2. 
	public CountriesDTO getDetail(String countries_id) throws Exception{
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
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));

		}
		//6. 자원해제
		DBConnector.disConect(rs, st, con);
		
		return countriesDTO;
	}

}
