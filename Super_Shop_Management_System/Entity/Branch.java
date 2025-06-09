package Entity;

public class Branch {
    private String branchName;
    private String branchId;
    private String location;
    private int totalEmployees;

    public Branch(String branchName, String branchId, String location, int totalEmployees) {
        this.branchName = branchName;
        this.branchId = branchId;
        this.location = location;
        this.totalEmployees = totalEmployees;
    }
	
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
	public void setBranchId(String branchId) {
        this.branchId = branchId;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setTotalEmployees(int totalEmployees) {
        this.totalEmployees = totalEmployees;
    }
	

    public String getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }

    public void showAllDetails() {
        System.out.println("Branch Name: " + branchName);
        System.out.println("Branch ID: " + branchId);
        System.out.println("Location: " + location);
        System.out.println("Total Employees: " + totalEmployees);
    }
    public String getBranchAsString(){
		return "---------------------------------------" +"\n"+
		"Name: " + branchName +"\n"+
		"ID: " + branchId + "\n" +
		"Location: " + location + "\n"+
		"Total Employees: " + totalEmployees +"\n"+
		"---------------------------------------" +"\n";
	}
}