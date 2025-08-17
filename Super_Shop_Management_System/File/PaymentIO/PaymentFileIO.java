package File.PaymentIO;

import java.util.*;
import java.io.*;

public class PaymentFileIO{
	
	public static void addPayment(String accountNumber,String amount,String pin){
		
		try{
			
			FileWriter fw = new FileWriter(new File("./File/PaymentIO/PaymentInfo.txt"),true);
			fw.write(accountNumber+";"+ amount+";"+pin);
			fw.close();
			
		}
		catch(Exception e ){
			e.printStackTrace(System.out);
		}
		
	}
	
	public static String getHistory(){
		String paymentsHistory="";
		try{
			Scanner sc = new Scanner(new File("./File/SellIO/SellRecords.txt"));
			
			while(sc.hasNextLine()){
				paymentsHistory+= sc.nextLine()+"\n";
					
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File not found");
		}
		return paymentsHistory;
	}
	
	
	
}