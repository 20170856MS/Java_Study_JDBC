package com.test;

import java.util.ArrayList;

import com.countries.CountriesDAO;
import com.countries.CountriesDTO;
import com.countries.CountriesView;
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
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//========================================================
		
		CountriesDAO countriesDAO = new CountriesDAO();
		CountriesView countriesView = new CountriesView();
		try {

			CountriesDTO countriesDTO = countriesDAO.getDetail("AU");
			countriesView.View(countriesDTO);
			
			ArrayList<CountriesDTO> ar = countriesDAO.getList();
			countriesView.View(ar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
