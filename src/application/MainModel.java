package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainModel {
	
	//Variables
	String data = null;
	
	//Methods for File A
	//Read and save file.
	public String LoadContentA() throws IOException {
		
		// Check if the file exists. If not, create a new file.
		if(!(new File("savea.txt").isFile())) {
			Files.createFile(Paths.get("savea.txt"));
	     }
	    
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("savea.txt")); 
		
		//Create a stringbuilder to hold strings.
	    StringBuilder myContent = new StringBuilder();
	   
	    // Read line-by-line from file
	    String currentLine = br.readLine();

	    // If there's still line to read, do this
	    while(currentLine != null) {
	    // Add these lines to the String builder
	    myContent.append(currentLine + "\n");
	    // Read the next line
	    currentLine = br.readLine();
	    }    
	    br.close();
	    return data = myContent.toString();
	    }
	
	public void WriteToFileA(String myStrings) throws IOException {
		
		if(!(new File("savea.txt").isFile())) {
			Files.createFile(Paths.get("savea.txt"));
	     }
		BufferedWriter bw = new BufferedWriter(new FileWriter("savea.txt"));
		bw.write(myStrings);
		bw.close();
	}
	
	//Methods for File B
	//Read and save file.
	public String LoadContentB() throws IOException {
		
		// Check if the file exists. If not, create a new file.
		if(!(new File("saveb.txt").isFile())) {
			Files.createFile(Paths.get("saveb.txt"));
	     }
	    
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("saveb.txt")); 
		
		//Create a stringbuilder to hold strings.
	    StringBuilder myContent = new StringBuilder();
	   
	    // Read line-by-line from file
	    String currentLine = br.readLine();

	    // If there's still line to read, do this
	    while(currentLine != null) {
	    // Add these lines to the String builder
	    myContent.append(currentLine + "\n");
	    // Read the next line
	    currentLine = br.readLine();
	    }    
	    br.close();
	    return data = myContent.toString();
	    }
	
	public void WriteToFileB(String myStrings) throws IOException {
		
		if(!(new File("saveb.txt").isFile())) {
			Files.createFile(Paths.get("saveb.txt"));
	     }
		BufferedWriter bw = new BufferedWriter(new FileWriter("saveb.txt"));
		bw.write(myStrings);
		bw.close();
	}
	
	//Different method to save to file.
	public void WriteToFile(String myStrings, String file) throws IOException {
		
		//If the file name matches, execute this.
		if (file.equalsIgnoreCase("savea")){	
		if(!(new File("savea.txt").isFile())) {
			Files.createFile(Paths.get("savea.txt"));
			}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("savea.txt"));
		bw.write(myStrings);
		bw.close();
		
		}else if (file.equalsIgnoreCase("saveb")) {
			
			if(!(new File("saveb.txt").isFile())) {
			Files.createFile(Paths.get("saveb.txt"));
			}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("saveb.txt"));
		bw.write(myStrings);
		bw.close();	
		}
	}
	
}

