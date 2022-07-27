package com.test;

import java.util.ArrayList;

import com.countries.CountriesDAO;
import com.regions.RegionDTO;
import com.regions.RegionsDAO;
import com.regions.RegionsView;
import com.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		
		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsView regionsView = new RegionsView();
		
		try {
			//regionsDAO.getList();
			//regionsDAO.getDetail(2);
			RegionDTO regionDTO = regionsDAO.getDetail(2);
			regionsView.View(regionDTO);
			
			ArrayList<RegionDTO> ar = regionsDAO.getList();
			regionsView.View(ar);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//========================================================
		
		CountriesDAO countriesDAO = new CountriesDAO();
		try {
			//countriesDAO.getList();
			countriesDAO.getDetail("AU");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
