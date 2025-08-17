package File.UserIO;

import File.UserIO.*;
import java.util.*;
import java.io.*;
import Entity.*;
import EntityList.*;

public class UserFileIO{
	public static boolean checkUser(String uname, String upass){
		boolean valid = false;
		try{
			Scanner sc = new Scanner(new File("./File/UserIO/UserInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				if(("a"+uname).equals(data[0]) && ("a"+upass).equals(data[1])){
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
			FileWriter fw = new FileWriter(new File("./File/UserIO/UserInfo.txt"),true);
			fw.write("a"+uname+";"+"a"+upass+";"+umail+";"+id+"\n");
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	
	public static boolean removeUser(String uname, String upass){
		boolean valid = false;
		try{
			Scanner sc = new Scanner(new File("./File/UserIO/UserInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				if(("a"+uname).equals(data[0]) && ("a"+upass).equals(data[1])){
					data[0]=null;
					data[1]=null;
					data[2]=null;
					data[3]=null;
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
	
}	
