package com.test;

import java.util.ArrayList;

import com.countries.CountriesDAO;
import com.countries.CountriesDTO;
import com.countries.CountriesView;
import com.employees.EmployeesDAO;
import com.regions.RegionDTO;
import com.regions.RegionsDAO;
import com.regions.RegionsView;
import com.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		
		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsView regionsView = new RegionsView();
		
		try {

			RegionDTO regionDTO = regionsDAO.getDetail(2);
			regionsView.View(regionDTO);
			
			ArrayList<RegionDTO> ar = regionsDAO.getList();
			regionsView.View(ar);
			
			//RegionDTO regionDTO = new RegionDTO();
			//regionDTO.setRegion_id(6);
			//regionDTO.setRegion_name("Mars");
			//int result = regionsDAO.setRegion(regionDTO);
			//if(result>0) {
			//	System.out.println("성공");
			//}else {
			//	System.out.println("실패");
			//}
			//
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//========================================================
	
		CountriesDAO countriesDAO = new CountriesDAO();
		CountriesView countriesView = new CountriesView();
		try {

			//CountriesDTO countriesDTO = countriesDAO.getDetail("AU");
			//countriesView.View(countriesDTO);
			
			//ArrayList<CountriesDTO> ar = countriesDAO.getList("AU");
			//countriesView.View(ar);
			
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id("MN");
			countriesDTO.setCountry_name("MONGOLIA");
			countriesDTO.setRegion_id(3);
			int result = countriesDAO.setCountry(countriesDTO);
			if(result >0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EmployeesDAO employeesDAO = new EmployeesDAO();
		try {
			//employeesDAO.getSalaryInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
