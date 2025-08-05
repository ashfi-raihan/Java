package EntityList;
import Entity.Employee;

public class EmployeeList{
	private Employee employees[];
	
	public EmployeeList(){
		employees = new Employee[500];
	}
	public EmployeeList(int size){
		employees = new Employee[size];
	}
	
	public void insert(Employee e){
		boolean flag = false;
		for(int i=0;i<employees.length;i++){
			if(employees[i] == null){
				employees[i] = e;
				flag = true;
				break;
			}
		}
		//if(flag){System.out.println("Employee inserted. ");}
		//else{System.out.println("Can not insert employee.");}	
	}
	
	public void removeById(String id){
		boolean flag = false;
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				if(employees[i].getId().equals(id) ){
					employees[i] = null;
					flag = true;
					break;
				}
			}
		}
		
		if(flag){System.out.println("Employee Deleted Successfully ");}
		else{System.out.println("No Employee with this Id !!");}
	}
	public void removeByName(String name){
		boolean flag = false;
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				if(employees[i].getName().equals(name) ){
					employees[i] = null;
					flag = true;
					break;
				}
			}
		}
		
		if(flag){System.out.println("Employee Deleted Successfully ");}
		else{System.out.println("No Employee with this name!!");}
	}
	
	
	public Employee getById(String id){
		Employee e = null;
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				if(employees[i].getId().equals(id) ){
					e = employees[i];
					break;
				}
			}
		}
		return e;
	}
	public Employee getByName(String name){
		Employee e = null;
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				if(employees[i].getName().equals(name) ){
					e = employees[i];
					break;
				}
			}
		}
		return e;
	}
	
	
	public void showAll(){
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				employees[i].showAllDetails();
			}
		}
	}
	public String getAllEmployeeAsString(){
		String s = "";
		for(int i=0;i<employees.length;i++){
			if(employees[i] != null){
				s+=employees[i].getEmployeeAsString()+"\n";
			}
		}
		return s;
	}
	
	public Employee [] getAllEmployeesArray(){
		return employees;
	}
}