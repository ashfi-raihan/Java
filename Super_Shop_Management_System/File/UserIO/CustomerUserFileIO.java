package File.UserIO;
import java.util.*;
import java.io.*;
import Entity.*;
import EntityList.*;

public class CustomerUserFileIO{
	public static boolean checkUser(String uname, String upass){
		boolean valid = false;
		try{
			Scanner sc = new Scanner(new File("./File/UserIO/CustomerUsersInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				if(("c"+uname).equals(data[0]) && ("c"+upass).equals(data[1])){
					valid = true;
					break;
				}
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		return valid;
	}
	
	public static void addUser(String uname, String upass,String umail, String id){
		try{
			FileWriter fw = new FileWriter(new File("./File/UserIO/CustomerUsersInfo.txt"),true);
			fw.write("c"+uname+";"+"c"+upass+";"+umail+";"+id+"\n");
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	
}	