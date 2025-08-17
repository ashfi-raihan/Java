package File.BranchIO;

import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.BranchList;

public class BranchFileIO {
	public static void addBranch(Branch b){
		try{
			FileWriter fw = new FileWriter(new File("./File/BranchIO/BranchInfo.txt"), true);
			fw.write(b.getBranchName() + ";" + b.getBranchId() + ";" + b.getLocation() + ";" +b.getTotalEmployees() + "\n");
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			e.printStackTrace(System.out);
			//System.out.println("File Not Found");
		}
	}
	
	public static void loadAllBranch(BranchList branches){
		try{
			Scanner sc = new Scanner(new File("./File/BranchIO/BranchInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				
				Branch b = new Branch(data[0], data[1], data[2], Integer.parseInt(data[3]));
						
				branches.insert(b);
			}
			sc.close();
		}
		catch(Exception e){
			e.printStackTrace(System.out);
			//System.out.println("File Not Found");
		}
		
	}
	
	public static void updateAllBranch(BranchList branches){
		try{
			FileWriter fw = new FileWriter(new File("./File/BranchIO/BranchInfo.txt"));
			Branch allBranch[] = branches.getAllBranchesArray();
			for(Branch b: allBranch){
				if(b != null){
					fw.write(b.getBranchName() + ";" + b.getBranchId() + ";" + b.getLocation() + ";" +b.getTotalEmployees() + "\n");
					fw.flush();
				}
			}
			fw.close();
		}
		catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
}

