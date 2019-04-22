package pricewatcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class checkManageItems {
	private int size;

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] InitialItems(String fileName, int info)throws IOException {

		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];

	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        String cut = "[,]";
	        String[] cell = line.split(cut);

	        for(int i=0; i<cell.length;i++){
	        	fileArray[i] = cell[i];
	            }
	        }
	    	
	    return fileArray;
	    }

	public static void deleteItem(String fileName, Item item)throws IOException{
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);


	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        String cut = "[,]";
	        String[] cell = line.split(cut);
	        String[] wordArray = new String[7];
	        for(int i=0; i<cell.length;i++){
	        	wordArray[i] = cell[i];
	        }
	        if (wordArray[1].contentEquals(item.url)) {
	        	
	        }else {
	        	FileWriter fw;
	            fw = new FileWriter(new File("fileName.txt"));
	            fw.write(String.format(line));
	        	fw.write(System.lineSeparator());
	        }
	    }
		
	}
	public static void addItem(Item item, String fileName, int info) throws IOException {
		
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];
	    int counter = 0; 
	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        fileArray[counter] = line;
	        counter++;
	        System.out.println(counter);
	    }
	    System.out.println(counter);
	    
	    FileWriter fw;
	    
	    fw = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName.txt"));
        
        
	    
        for(int i = 0; i < counter; i++) {
        	fw.write(String.format(fileArray[i]));
        	fw.write(System.lineSeparator());
        }
             
        fw.write(String.format(item.name+","));
            
        fw.write(String.format(item.url+","));
   
        fw.write(String.format(item.initialPrice,","));
            
        fw.write(String.format(item.currentPrice+","));
            
        fw.write(String.format(item.change+","));
   
        fw.write(String.format(item.date,","));
            
            
        fw.write(System.lineSeparator()); //new line
        fw.close();
	}
	public static void eraseFile() throws IOException {
		FileWriter fw;
		fw = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName.txt"));
		
		//writer.print("");
		//writer.close();
	}
	public static void finalItems(String fileName, int info) throws IOException {
		File inputFile = new File (fileName);
	    Scanner sc = new Scanner (inputFile);

	    String[] fileArray = new String [info];
	    int counter = 0; 
	    while(sc.hasNextLine()){
	    	String line	= sc.nextLine();
	        fileArray[counter] = line;
	        System.out.println(fileArray[counter]);
	        counter++;
	        System.out.println(counter);
	    }
	    System.out.println(counter);
	    
	    FileWriter fw2;
	    eraseFile();
	    fw2 = new FileWriter(new File("C:\\Users\\edgar\\eclipse-workspace\\homework2EscobedoEdgarJorgeQuinonez\\fileName"));
	    fw2.close();
	    FileWriter fwFinal;
	   
	    fwFinal = new FileWriter(new File("fileNameFinal.txt"));
        
        
	    
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(fileArray[i]));
        	fwFinal.write(System.lineSeparator());
        }
        fwFinal.close();
        
		
	}
	/**
	 * @throws IOException ***********************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void adItem(String fileName, Item item) throws IOException {
		try
		{
		    String filename= "MyFile.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(System.lineSeparator());
		    fw.write(item.name+","+item.url+","+item.initialPrice+","+item.currentPrice+","+item.change+","+item.date);
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		Scanner file;
        PrintWriter writer;
        
        try {

            file = new Scanner(new File("myFile.txt"));
            writer = new PrintWriter("myFile2.txt");

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write(System.lineSeparator());
                }
            }
            /*
            FileWriter fwOb = new FileWriter("myFile.txt", false); 
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            
            
            file.close();
            writer.close();
            goBack("myFile2.txt");
            */
            /*
            File file2 = new File("myFile2.txt"); 
  		  
    		BufferedReader br = new BufferedReader(new FileReader(file2)); 
    		  
    		String st; 
    		String filename= "MyFile.txt";
	    	FileWriter fw2 = new FileWriter(filename,true);
    		//while ((st = br.readLine()) != null) {}
    			//if (st!=null && st.length() != 0)
    		       //fw.println(words[i]);
    				//System.out.println(st);
    				//fw2.write(System.lineSeparator());
		    		//fw2.write(st);
		    //fw2.close();
            
			*/
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
	}
	public static void goBack(String fileName) {
		try
		{
			File file = new File(fileName); 
			  
			BufferedReader br = new BufferedReader(new FileReader(file)); 
		    String filename2= "MyFile.txt";
		    FileWriter fw = new FileWriter(filename2,true); //the true will append the new data
		    String st; 
			while ((st = br.readLine()) != null) {
				fw.write(System.lineSeparator());
				fw.write(st);
				
			}
			fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
	
	
	public static void seeItems(String fileName) throws IOException {
		File file = new File(fileName); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		while ((st = br.readLine()) != null) 
			System.out.println(st);
	}
	public static void changeItemName(String fileName, String name, String newName) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
            
	        if ( cell[0].equals(name)){
	           	System.out.println(counter);
	           	info[counter] = newName+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
	        }else {
	           	info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
	          
            }
            
            counter++;
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	if (i != counter - 1) {
        		fwFinal.write(System.lineSeparator());
        	}
        }
        fwFinal.close();	
	}
	public static void changeItemURL(String fileName, String url, String newUrl) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
            
	        if ( cell[1].equals(url)){
	           	System.out.println(counter);
	           	info[counter] = cell[0]+","+newUrl+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
	        }else {
	            info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
	        }
            
            counter++;
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	if (i != counter - 1) {
        		fwFinal.write(System.lineSeparator());
        	}
        }
        fwFinal.close();	
	}
	public static void deleteItem(String fileName, String name, String url) throws IOException {
		File inputFile = new File (fileName);
        Scanner sc = new Scanner (inputFile);

        String[] info = new String[1000];
        int counter = 0;
        while(sc.hasNextLine()){
            String line	= sc.nextLine();
            String cut = "[,]";
            String[] cell = line.split(cut);
	        if ( cell[0].equals(name) && cell[1].equals(url)){
	        }else {
	        	info[counter] = cell[0]+","+cell[1]+","+cell[2]+","+cell[3]+","+cell[4]+","+cell[5];
	        	counter++;
	        }
        }
	    FileWriter fwFinal;
	    fwFinal = new FileWriter(new File("myFile.txt"));
        for(int i = 0; i < counter; i++) {
        	fwFinal.write(String.format(info[i]));
        	if (i != counter - 1) {
        		fwFinal.write(System.lineSeparator());
        	}
        }
        fwFinal.close();	
	}
	
	public static void main(String[] args) throws IOException {
		
		File inputFile = new File ("fileName.txt");
	    Scanner sc = new Scanner (inputFile);
	    Scanner scan = new Scanner(System.in);
	    int counter = 1000; 
	    System.out.println("Please select an option");
	    System.out.println("1: see items");
	    System.out.println("2: add item");
	    System.out.println("3: delete item");
	    System.out.println("4: change existing item name");
	    System.out.println("5: change existing item url");
	    System.out.println("6: exit");
	    
	    String option = scan.next();
	    String newName = "";
	    String newUrl = "";
	    while(option != "6") {
		    switch(option) {
		    	case "1": option = "1";
		    		seeItems("myFile.txt");
		    		System.out.println("Select an option:");
		    		option = scan.next();
		    		break;
		    	case "2": option = "2";
		    		System.out.println("Select the name of the item you want to add");
		    		newName = scan.next();
		    		System.out.println("Select the url of the item you want to add");
		    		newUrl = scan.next();
		    		Item newItem = new Item(newName, newUrl);
		    		adItem("myFile.txt", newItem);
		    		System.out.println("Select an option:");
		    		option = scan.next();
		    		break;
		    	case "3": option = "3";
		    		System.out.println("Select the name of the file to be erased");
		    		String name = scan.next();
		    		System.out.println("Select the url of the file to be erased");
		    		String url = scan.next();
	    		
		    		deleteItem("myFile.txt", name, url);
		    		System.out.println("Select an option:");
		    		option = scan.next();
		    		break;
		    		
		    	case "4": option = "4";
		    		System.out.println("Give the name of the item you want to change");
		    		String nameOption4 = scan.next();
		    		System.out.println("Give the name you want to change it to");
		    		String newNameOption4 = scan.next();
		    		
		    		changeItemName("myFile.txt", nameOption4, newNameOption4);
		    		System.out.println("Select an option:");
		    		option = scan.next();
		    		break;
		    	case "5": option = "5";
		    		System.out.println("Give the name of the item you want to change");
		    		String urlOption4 = scan.next();
		    		System.out.println("Give the name you want to change it to");
		    		String newUrlOption4 = scan.next();
		    	
	    			changeItemURL("myFile.txt", urlOption4, newUrlOption4);
	    			System.out.println("Select an option:");
	    			option = scan.next();
	    			break;
		    
		    	default:
		    		System.out.println("Wrong input, select an option:");
		    		System.out.println("Please select an option");
		    	    System.out.println("1: see items");
		    	    System.out.println("2: add item");
		    	    System.out.println("3: delete item");
		    	    System.out.println("4: change existing item name");
		    	    System.out.println("5: change existing item url");
		    	    System.out.println("6: exit");
		    		option = scan.next();
		    		break;
		    	
		    }
	    }
	}
}

//

