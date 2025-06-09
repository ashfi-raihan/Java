package Entity;


public class Product{
	
	private String productName;
	private String productId;
	private double productPrice;	
	private Object productType;
	private String companyName;
	private String manufacturedDate;
	private Object originOfProduct;
	private int quantity;
		
	public Product() {		}
	
	public Product(String productName, String productId, double productPrice, String manufacturedDate) {
		setProductName(productName);
		setProductId(productId);
		setProductPrice(productPrice);
		setManufacturedDate(manufacturedDate);
	}
	
	public Product(String productName, String productId, double productPrice, Object productType, String companyName, String manufacturedDate, Object originOfProduct){
		this.productName = productName;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productType = productType;
		this.companyName = companyName;
		this.manufacturedDate = manufacturedDate;
		this.originOfProduct = originOfProduct;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getProductId(){
		return productId;
	}
	public void setProductPrice(double productPrice){
		if(productPrice > 0) {
		this.productPrice = productPrice;
		}
		else {
			System.out.println("Invalid Price! Please try again..");
		}
	}
	public double getProductPrice(){
		return productPrice;
	}
	public void setProductType(Object productType){
		this.productType = productType;
	}
	public Object getProductType(){
		return productType;
	}
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	public String getCompanyName(){
		return companyName;
	}	
	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public String getManufacturedDate() {
		return manufacturedDate;
	}
	public void setOriginOfProduct(Object originOfProduct) {
		this.originOfProduct = originOfProduct;
	}
	public Object getOriginOfProduct() {
		return originOfProduct;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public int getQuantity(){
		return quantity;
	}

	
	public void showDetails(){
		System.out.println("Product Name    : " + productName);
        System.out.println("Product Id      : " + productId);
        System.out.println("Product Price   : " + productPrice);
        System.out.println("Product Type    : " + productType);
		System.out.println("Mnufactured by  : " + companyName);
		System.out.println("Mnufactured Date: " + manufacturedDate);
		System.out.println("Made in " + originOfProduct);
	}
	
	public String getProductAsString() {
		return 
				"~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~" + "\n" +
				"Product Name    : " + productName + "\n" +
				"Product Id      : " + productId + "\n" +
				"Product Price   : " + productPrice + "\n" +
				"Product Type    : " + productType + "\n" +
				"Mnufactured by  : " + companyName + "\n" +
				"Mnufactured Date: " + manufacturedDate + "\n" +
				"Made in " + originOfProduct + "\n" +
				"~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~";
	}
	
	
	public String getSellProductAsString() {
		return 
				
				"Product Name     : " + productName + "\n" +
				"Product Id       : " + productId + "\n" +
				"Product Price    : " + productPrice + "\n" +
				"Product Quantiy    : " + quantity + "\n" +
				"Mnufactured Date : " + manufacturedDate + "\n" +
				"~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~" + "\n";
	}
}