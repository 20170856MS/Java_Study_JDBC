package com.test;

import com.countries.CountriesDAO;
import com.regions.RegionsDAO;
import com.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		
		//RegionsDAO regionsDAO = new RegionsDAO();
		//try {
		//	regionsDAO.getList();
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		
		CountriesDAO countriesDAO = new CountriesDAO();
		try {
			countriesDAO.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
				

	}

}
