package com.smartdatasolutions.test.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;

public class MemberExporterImpl implements MemberExporter {

	@Override
	public void writeMember( Member member, Writer writer ) throws IOException {
		writer.write( member.toCSVString( ) );
		writer.write("\n"); 
	}
	
	public boolean unique(Member member , Writer writer) {
		
		return true;
	}
	

}
