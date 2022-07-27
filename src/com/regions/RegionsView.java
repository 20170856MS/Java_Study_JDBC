package com.regions;

import java.util.ArrayList;

public class RegionsView {
	
	public void View(RegionDTO regionDTO) {
		System.out.println("Region_ID\t Region_name");
		System.out.println("=========================");
		System.out.print(regionDTO.getRegion_id()+"\t");
		System.out.println(regionDTO.getRegion_name());
		
	}
	
	public void View(ArrayList<RegionDTO> ar) {
		for(RegionDTO regionDTO : ar) {
			System.out.println("Region_ID\t Region_name");
			System.out.println("=========================");
			System.out.print(regionDTO.getRegion_id()+"\t");
			System.out.println(regionDTO.getRegion_name());
		}
		
	}
}
