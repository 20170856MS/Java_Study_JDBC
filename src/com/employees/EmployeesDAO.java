package com.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.DBConnector;

public class EmployeesDAO {
	
	public void getSalaryInfo() throws Exception {
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.SQL문 작성
		String sql = "SELECT SUM(SALARY), AVG(SALARY), MAX(SALARY) AS MAX FROM EMPLOYEES";
		//3.미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.? 가 있으면 값을 세팅
		
		//5.최종전송 후 결과처리
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			int sum = rs.getInt("SUM(SALARY)");
			double avg = rs.getDouble(2);
			int max = rs.getInt("MAX");
			
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		//6.자원해제
		DBConnector.disConect(rs, st, con);
	}
}
