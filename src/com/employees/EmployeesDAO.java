package com.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.departments.DepartmentsDTO;
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
	
	public void getJoinTest(EmployeesDTO employeesDTO) throws Exception{
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.sql문 작성
		String sql = "SELECT E.LAST_NAME, E.SALARY, D.DEPARTMENT_NAME FROM employees E INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID WHERE EMPLOYEE_ID = 100;";
		//3.미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.? 값 처리
		st.setInt(1, employeesDTO.getEmployee_id());
		//5. 최종전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setLast_Name(rs.getString("LAST_NAME"));
			employeesDTO.setSalary(rs.getInt("SALARY"));
			DepartmentsDTO dt = new DepartmentsDTO();
			dt.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
		}
		//6.연결해제
		DBConnector.disConect(rs, st, con);
	}
}
