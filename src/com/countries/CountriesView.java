package com.countries;


public class CountriesView {
	
	public void View(CountriesDTO countriesDTO) {
		System.out.println("Contry_ID\t Contry_name");
		System.out.println("=========================");
		System.out.print(countriesDTO.getCountry_id()+"\t");
		System.out.println(countriesDTO.getCountry_name());
		System.out.println(countriesDTO.getRegion_id());
		
	}
	
}
