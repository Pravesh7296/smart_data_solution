package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		return  new ArrayList<>(new HashSet<>(membersFromFile));
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
	        
		return validMembers.stream()
                .collect(Collectors.groupingBy(Member::getState));
	}

	public static void main( String[] args ) {
		//TODO
		 Main converter = new Main();
		 File inputFile = new File("Members.txt");
		 String outputFilePath = "./output/";
		 String outputFileName = "OutputFile.csv";
		System.out.println("Files Created");
	        try {
				converter.convert(inputFile,outputFilePath ,outputFileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
