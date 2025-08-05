package EntityList;
import Entity.Product;

public class ProductList{
	
	private Product products[];
	
	public ProductList(){
		products = new Product[500];
	}
	
	public ProductList (int size){
		products = new Product[size];
	}
	
	// Show all Product
	public void showAllProducts(){
		for(int i=0; i<products.length; i++){
			if(products[i] != null){
				products[i].showDetails();
			}
		}
	}
	
	// Insert new product
	public void insertProduct (Product product){
		boolean flag = false;
		for(int i = 0; i < products.length; i ++){
			if (products[i] == null){
				products[i] = product;
				flag = true;
				break;
			}
		}		
	}
	
	// Remove a product
	public void removeProduct (String productId){
		boolean flag = false;
		for (int i = 0; i < products.length; i ++){
			if (products[i] != null){
				if (products[i].getProductId().equals(productId)){
					products[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("\nProduct Delete Successfull...\n\n");
		}
		else{
			System.out.println("\nNo Product found!!!\n\n");
		}
	}
	
	// Get a product by Id
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
	public String getAllProductAsString() {
		String s = "";
		for(int i = 0; i < products.length; i++){
			if(products[i] != null){
				s += products[i].getProductAsString() + "\n";
			}
		}
		return s;
	}
	
	public Product[] getAllProductsArray(){
		return products;
	}
}