package Entity;

public class Employee extends Person{
	private String designation;
	private String branch;
	private int salary;
	
	public Employee(){}
	public Employee(String name, String id, int age, Object gender, String designation, String branch, int salary){
		super(name,id,age,gender);
		setDesignation(designation);
		setBranch(branch);
		setSalary(salary);
	}
	
	public void setDesignation(String designation){
		this.designation = designation;
	}
	public String getDesignation(){
		return designation;
	}
	
	public void setBranch(String branch){
		this.branch = branch;
	}
	public String getBranch(){
		return branch;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	public int getSalary(){
		return salary;
	}
	
	public void showAllDetails(){
		super.showAllDetails();
		System.out.println("Designation: " + designation);
		System.out.println("Branch: " + branch);
		System.out.println("Salary: " + salary);
	}
	
	public String getEmployeeAsString(){
		return "---------------------------------------" +"\n"+
		"Name: " + getName()+"\n"+
		"ID: " + getId() +"\n"+
		"Age: " + getAge() +"\n"+
		"Gender: " + getGender() +"\n"+
		"Designation: " + designation +"\n"+
		"Branch: " + branch +"\n"+
		"Salary: " + salary +"\n"+
		"---------------------------------------" +"\n";
	}
}
