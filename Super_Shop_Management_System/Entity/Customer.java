package Entity;

public class Customer extends Person {
    private String phoneNumber;
    private String address;

    public Customer() {}

    public Customer(String name, String id, int age, Object gender, String phoneNumber, String address) {
        super(name, id, age, gender);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void showAllDetails() {
        super.showAllDetails();
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
    }
	
	
	public String getCustomerAsString(){
		return "---------------------------------------" +"\n"+
		"Name: " + getName()+"\n"+
		"ID: " + getId() +"\n"+
		"Age: " + getAge() +"\n"+
		"Gender: " + getGender() +"\n"+
		"Phone Number: " + getPhoneNumber() +"\n"+
		" Address: " +  getAddress() +"\n"+
		"---------------------------------------" +"\n";
	}
}