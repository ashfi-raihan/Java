package File.SellIO;

import java.util.*;
import java.io.*;

import EntityList.*;

public class SellFileIO{
	
	public static void addRecords(String s){
		try{
			FileWriter fw = new FileWriter(new File("./File/SellIO/SellRecords.txt"),true);
			fw.write(s +"\n"+"*************************************************************"+"\n");
			fw.close();
		}
		catch(Exception e){
			System.out.println("File not Found");
		}
	}
	
	public static void getRecords(String info []){
		try{
			Scanner sc = new Scanner(new File("../File/SellIO/SellRecords.txt"));
			while(sc.hasNextLine()){
				String s[] = sc.nextLine().split("*************************************************************");
				
				for(int j=0; j<s.length; j++){
					//String info = new String[];
					for(int i=0; i<info.length; i++){
						if(info[i]==null){
							info[i] = s[j];
						}
					}
				}				
			}
		}
		catch(Exception e){
			System.out.println("File not found");
		}
	}
		
	public static String getHistory(){
		String sellsHistory="";
		try{
			Scanner sc = new Scanner(new File("./File/SellIO/SellRecords.txt"));
			
			while(sc.hasNextLine()){
				sellsHistory+= sc.nextLine()+"\n";
					
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File not found");
		}
		return sellsHistory;
	}
	
	
}