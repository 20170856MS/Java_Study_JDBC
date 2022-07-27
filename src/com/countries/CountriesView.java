package com.countries;

import java.util.ArrayList;

import com.regions.RegionDTO;

public class CountriesView {
	
	public void View(CountriesDTO countriesDTO) {
		System.out.println("Contry_ID\t Contry_name");
		System.out.println("=========================");
		System.out.print(countriesDTO.getCountry_id()+"\t");
		System.out.println(countriesDTO.getCountry_name());
		System.out.println(countriesDTO.getRegion_id());
		
		
	}
	
	public void View(ArrayList<CountriesDTO> ar) {
		for(CountriesDTO countriesDTO : ar) {
			System.out.println("Country_ID\t Country_name\t region_id");
			System.out.println("=========================");
			System.out.print(countriesDTO.getCountry_id()+"\t");
			System.out.println(countriesDTO.getCountry_name());
			System.out.println(countriesDTO.getRegion_id());
		}
		
	}
}
