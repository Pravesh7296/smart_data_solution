package com.smartdatasolutions.test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class MemberFileConverter {
	/*
	 * NOTE: Do not modify this class
	 */
	protected abstract MemberExporter getMemberExporter( );

	protected abstract MemberImporter getMemberImporter( );

	protected abstract List< Member > getNonDuplicateMembers( List< Member > membersFromFile );

	protected abstract Map< String, List< Member >> splitMembersByState( List< Member > validMembers );

	public void convert( File inputMemberFile, String outputFilePath, String outputFileName ) throws Exception {

		/*
		 * Read :
		 */
		MemberImporter memberImporter = getMemberImporter( );
		List< Member > membersFromFile = memberImporter.importMembers( inputMemberFile );
       
		/*
		 * Filter :
		 */

		List< Member > validMembers = getNonDuplicateMembers( membersFromFile );
		Map< String, List< Member >> membersFilteredByState = splitMembersByState( validMembers );

		/*
		 * Write :
		 */
		for ( Map.Entry< String, List< Member >> map: membersFilteredByState.entrySet( ) ) {
			

			String state = map.getKey( );
			List< Member > membersPerState = map.getValue( );

			File outputFile = new File( outputFilePath + File.separator + state + "_" + outputFileName );
            
			MemberExporter exporter = getMemberExporter( );
			writeMembers( outputFile, exporter, membersPerState );

		}

	}

	private void writeMembers( File outputFile, MemberExporter exporter, List< Member > members ) throws Exception {
		
		 File file = new File(outputFile+"");
		 
         if(file.createNewFile()) {
        	
         }else {
        	 file.delete();
        	 file.createNewFile();
         }
         Set<Member> uniqueMembers = new HashSet(members);
    	 
 	    Writer writer = new FileWriter( outputFile ,true);
	       
 		for ( Member member: uniqueMembers) {
 			exporter.writeMember( member, writer );
 		}
 		writer.flush( );
 		writer.close( );
        	
        
		
	}

}
