package Entity;

public abstract class Person{
	private String name;
	private String id;
	private int age;
	private Object gender;
	
	public Person(){}
	public Person(String name, String id, int age, Object gender){
		setName(name);
		setId(id);
		setAge(age);
		setGender(gender);
	}
	
	public void setName(String name){
		this.name = name; 
	}
	public String getName(){
		return name;
	}
	
	public void setId(String id){
		this.id = id; 
	}
	public String getId(){
		return id;
	}
	
	public void setAge(int age){
		this.age = age; 
	}
	public int getAge(){
		return age;
	}
	
	public void setGender(Object gender){
		this.gender = gender; 
	}
	public Object getGender(){
		return gender;
	}
	
	public void showAllDetails(){
		System.out.println("Name: " + getName());
		System.out.println("ID: " + getId());
		System.out.println("Age: " + getAge());
		System.out.println("Gender: " + getGender());
	}
}	