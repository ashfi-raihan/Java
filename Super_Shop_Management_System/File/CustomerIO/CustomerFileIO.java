package File.CustomerIO;

import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.CustomerList;

public class CustomerFileIO {
	public static void addCustomer(Customer c){
		try{
			FileWriter fw = new FileWriter(new File("./File/CustomerIO/CustomerInfo.txt"), true);
			fw.write(c.getName()+";"+c.getId()+";"+ c.getAge()+";"+c.getGender()+";"+
					c.getPhoneNumber()+";"+c.getAddress()+"\n");
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	public static void updateAllCustomer(CustomerList customers){
		try{
			FileWriter fw = new FileWriter(new File("./File/CustomerIO/CustomerInfo.txt"));
			Customer allCustomers[] = customers.getAllCustomersArray();
			for(Customer c: allCustomers){
				if(c!=null){
				fw.write(c.getName()+";"+c.getId()+";"+ c.getAge()+";"+c.getGender()+";"+
					c.getPhoneNumber()+";"+c.getAddress()+"\n");
				fw.flush();
				}
			}
			fw.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	
	public static void loadAllCustomer(CustomerList customers){
		try{
			Scanner sc = new Scanner(new File("./File/CustomerIO/CustomerInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				
				Customer c = new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5]);
						
				customers.insert(c);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
	
}



// Unused codes

	
	/*
	// Removing by id 
	public static void removeCustomer(String id){
		try{
			Scanner sc = new Scanner(new File("./File/CustomerIO/CustomerInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				c = new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5]);
				if(c.getId().equals(id)){
					data[0] = "";
					data[1] = "";
					data[2] = "";
					data[3] = "";
					data[4] = "";
					data[5] = "";
					System.out.println("Data deleted from the text file");
					
				}
				else{
					System.out.println("Data not found");
				}
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
	
	public static void removeCustomer(String id,CustomerList customers){
		try{
			Scanner sc = new Scanner(new File("./File/CustomerIO/CustomerInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				Customer c = new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5]);
				if(c.getId().equals(id)){
					data[0] = "";
					data[1] = "";
					data[2] = "";
					data[3] = "";
					data[4] = "";
					data[5] = "";
					
					customers.removeById(id);
					loadAllCustomer(customers);
					System.out.println("Data deleted from the text file");
					
				}
				else{
					System.out.println("Data not found");
				}
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
	
	public static void updateCustomer(Customer c){
		try{
			Scanner sc = new Scanner(new File("./File/CustomerIO/CustomerInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				Customer tempC = new Customer(data[0],data[1],Integer.parseInt(data[2]),data[3],data[4],data[5]);
				if(c.getId().equals(data[1])){
					tempC = c;
					
					System.out.println("Data updated from the text file");
					
				}
				else{
					System.out.println("Data not found");
				}
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
	*/

