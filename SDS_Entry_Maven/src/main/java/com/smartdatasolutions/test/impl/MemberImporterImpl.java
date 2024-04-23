package com.smartdatasolutions.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {


		
		
		 List<Member> members = new ArrayList<>();
	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	        	String line = br.readLine();
	            while (line!= null) {
	            	
	                String id = line.substring(0, 12).trim();
//	                System.out.println(id);
	                String lastName = line.substring(12, 37).trim();
//	                System.out.println(lastName);
	                String firstName = line.substring(37, 62).trim();
//	                System.out.println(firstName);
	                String address = line.substring(62, 92).trim();
//	                System.out.println(address);
	                String city = line.substring(92, 112).trim();
//	                System.out.println(city);
	                String state = line.substring(112, 116).trim();
//	                System.out.println(state);
	                String zip = line.substring(116, 121).trim();
//	                System.out.println(zip);

	                members.add(new Member(id, firstName, lastName, address, city,state, zip));
	                line = br.readLine();
	            }
	        }
	        return members;
	    }
	}
	
	


