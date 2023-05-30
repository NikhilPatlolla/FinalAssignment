package com.nikhil.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sample {
	public static void main(String[] args) throws IOException {
		String location = "src\\com\\nikhil\\data\\input.txt";
		BufferedReader reader = new BufferedReader(new FileReader(location));
		String line; 
		while((line=reader.readLine()) != null) {
			
			//Skipping the headers of the file
			if(line.startsWith("NAME")){
				continue; 
			}
			//the lines are separated by a "," in the file
			String[] values = line.split(",");
//			
//			pstmt.setString(1, values[0].trim());
//			pstmt.setString(2, values[1].trim());
			
//			pstmt.addBatch();
			
			System.out.println("The name is "+ values[0].trim());
			System.out.println("The address is "+ values[1].trim());
			System.out.println("\n\n");
			
		}
		reader.close();	
	}
}