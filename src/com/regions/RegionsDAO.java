package com.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnector;

public class RegionsDAO {
	
	public int setRegion(RegionDTO regionDTO) throws Exception{
		
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.SQL작성
		String sql = "INSERT INTO REGIONS VALUES(?,?)";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.? 세팅
		st.setInt(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		//5. 최종전송 후 결과처리
		int result = st.executeUpdate();
		//6.자원해제
		DBConnector.disConect(st, con);
		
		return result;
	}
	
	
	//1. Regions 테이블의 모든 데이터 가져오기
	public ArrayList<RegionDTO> getList() throws Exception {
		ArrayList<RegionDTO> ar = new ArrayList();
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
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getInt("Region_id"));
			regionDTO.setRegion_name(rs.getString("Region_name"));
			ar.add(regionDTO);
		}
		
		//6. 자원해제
		DBConnector.disConect(rs, st, con);
		
		return ar;
	}
	
	
	//2. Regions에서 하나의 결과
	public RegionDTO getDetail(int region_id) throws Exception{
		RegionDTO regionDTO = null;
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		//2.Query문 작성
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?값 세팅
		// WHERE NUM BETEEN ?(1) AND ?(2);
		st.setInt(1, region_id);
		//5. 최종 전송후 결과처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			regionDTO = new RegionDTO();
			int rId = rs.getInt(1);
			regionDTO.setRegion_id(rId);
			String rName = rs.getString(2);
			regionDTO.setRegion_name(rs.getString(2));

		}
		//6. 자원해제
		DBConnector.disConect(rs, st, con);
		
		return regionDTO;
	}

}
