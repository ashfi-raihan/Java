package EntityList;

import Entity.Customer;

public class CustomerList{
	private Customer customers[];
	
	public CustomerList(){
		customers = new Customer[100];
	}
	public CustomerList(int size){
		customers = new Customer[size];
	}
	
	
	public void insert(Customer c){
		boolean flag = false;
		for(int i=0;i<customers.length;i++){
			if(customers[i] == null){
				customers[i] = c;
				flag = true;
				break;
			}
		}
		//if(flag){System.out.println("Customers inserted. ");}
		//else{System.out.println("Can not insert Customers.");}	
	}
	
	public void removeById(String id){
		boolean flag = false;
		for(int i=0;i<customers.length;i++){
			if(customers[i] != null){
				if(customers[i].getId().equals(id) ){
					customers[i] = null;
					flag = true;
					break;
				}
			}
		}
		
		if(flag){System.out.println("Customer Deleted Successfully ");}
		else{System.out.println("No Customer with this Id !!");
		}
	}
		
	public Customer getById(String id){
		Customer c = null;
		for(int i=0;i<customers.length;i++){
			if(customers[i] != null){
				if(customers[i].getId().equals(id) ){
					c = customers[i];
					break;
				}
			}
		}
		return c;
	}
	
	public void showAll(){
		for(int i=0;i<customers.length;i++){
			if(customers[i] != null){
				customers[i].showAllDetails();
			}
		}
	}
	
	public String getAllCustomerAsString(){
		String s = "";
		for(int i=0;i<customers.length;i++){
			if(customers[i] != null){
				s+=customers[i].getCustomerAsString()+"\n";
			}
		}
		return s;
	}
	public Customer[] getAllCustomersArray(){
		return customers;
	}
		
}