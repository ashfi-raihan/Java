package File.ProductIO;

import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.*;

public class ProductFileIO {
	public static void addProduct(Product p){
		try{
			FileWriter fw = new FileWriter(new File("./File/ProductIO/ProductInfo.txt"), true);
			fw.write(p.getProductName() + ";" + p.getProductId() + ";" + p.getProductPrice() + ";" +p.getProductType() + ";" 
			+ p.getCompanyName() + ";" + p.getManufacturedDate() + ";" + p.getOriginOfProduct() + "\n");
			fw.flush();
			fw.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	
	public static void loadAllProduct(ProductList products){
		try{
			Scanner sc = new Scanner(new File("./File/ProductIO/ProductInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				
				Product p = new Product(data[0], data[1], Double.parseDouble(data[2]), 
						data[3], data[4], data[5], data[6]);
						
				products.insertProduct(p);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
	
	public static void updateAllPriducts(ProductList products){
		try{
			FileWriter fw = new FileWriter (new File("./File/ProductIO/ProductInfo.txt"));
			Product allProducts [] = products.getAllProductsArray();
			for(Product p : allProducts){
				if(p!=null){
					fw.write(p.getProductName() + ";" + p.getProductId() + ";" + p.getProductPrice() + ";" +p.getProductType() + ";" 
					+ p.getCompanyName() + ";" + p.getManufacturedDate() + ";" + p.getOriginOfProduct() + "\n");
					fw.flush();
				}
			}
			fw.close();
		}
		catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	public static void loadProductForSell(SellList products){
		try{
			Scanner sc = new Scanner(new File("./File/ProductIO/ProductInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				
				Product p = new Product(data[0], data[1], Double.parseDouble(data[2]), data[5]);
						
				products.insertSellProduct(p);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("File Not Found");
		}
		
	}
}

