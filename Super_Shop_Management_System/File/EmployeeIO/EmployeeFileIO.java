package File.EmployeeIO;

import Entity.*;
import EntityList.*;
import GUI.*;

import java.io.*;
import java.util.*;

public class EmployeeFileIO{
	
	public static void addEmployee(Employee em){
		try{
			FileWriter fw = new FileWriter(new File("./File/EmployeeIO/EmployeeInfo.txt"),true);
			fw.write(em.getName()+";"+em.getId()+";"+ em.getAge()+";"+em.getGender()+";"+
					em.getDesignation()+";"+em.getBranch()+";"+em.getSalary() +"\n");
			//fw.flush();		
			fw.close();	
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}	
	}
	
	
	public static void loadAllEmployee(EmployeeList employees){
		try{
			Scanner sc = new Scanner(new File("./File/EmployeeIO/EmployeeInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				
				Employee e = new Employee(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],Integer.parseInt(data[6]));
				
				employees.insert(e);
			}
			sc.close();
		}	
		catch(Exception e){
				System.out.println("File not found");
			
		}
	}
	
	
	public static void updateAllEmployee(EmployeeList employees){
		try{
			FileWriter fw = new FileWriter(new File("./File/EmployeeIO/EmployeeInfo.txt"));  // rewriting moode tai true likha lage nai 
			Employee allEmployee[] = employees.getAllEmployeesArray();
		
			for(Employee em : allEmployee){
				if(em != null){
					fw.write(em.getName()+";"+em.getId()+";"+ em.getAge()+";"+em.getGender()+";"+
						em.getDesignation()+";"+em.getBranch()+";"+em.getSalary() +"\n");
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