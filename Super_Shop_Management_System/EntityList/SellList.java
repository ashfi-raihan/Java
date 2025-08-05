package EntityList;

import Entity.*;

public class SellList{
	Product products[];
	
	public SellList(){
		products = new Product[1000];
	}
	
	public Product getByProductId(String productId){
		Product p = null;
		for (int i = 0; i < products.length; i ++){
			if(products[i] != null){
				if (products[i].getProductId().equals(productId)){
					 p = products[i];
					 break;
				}
			}
		}
		return p;
	}
	
	public void insertSellProduct (Product product){
		for(int i = 0; i < products.length; i ++){
			if (products[i] == null){
				products[i] = product;
				break;
			}
		}		
	}
	
	
	public String getAllSellProductAsString(){
		String s="";
		for(int i=0; i<products.length; i++){
			if(products[i] != null){
				s += products[i].getSellProductAsString();
			}
		}
		return s;
	}

	public Product[] getAllProductsArray(){
		return products;
	}

}