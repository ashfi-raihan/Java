package EntityList;

import Entity.Branch;

public class BranchList{
    private Branch branches[];
    	
    public BranchList(){
    		branches = new Branch[100];
    }
    public BranchList(int size){
    		branches = new Branch[size];
   	}
    	
    public Branch getById(String branchId){
    		Branch b = null;
    		for(int i=0;i<branches.length;i++){
    			if(branches[i] != null){
    				if(branches[i].getBranchId().equals(branchId) ){
    					b = branches[i];
    					break;
    				}
    			}
    		}
    		return b;
    } 
    public void removeById(String branchId){
    		boolean flag = false;
    		for(int i=0;i<branches.length;i++){
    			if(branches[i] != null){
    				if(branches[i].getBranchId().equals(branchId) ){
    					branches[i] = null;
    					flag = true;
    					break;
    				}
    			}
    		}
    		
    		if(flag){System.out.println("Branch Deleted Successfully ");}
    		else{System.out.println("No Branch with this Id !!");}
    }	
    public void insert(Branch b){
    		boolean flag = false;
    		for(int i=0;i<branches.length;i++){
    			if(branches[i] == null){
    				branches[i] = b;
    				flag = true;
    				break;
    			}
    		}
    		//if(flag){System.out.println("Branch inserted. ");}
    		//else{System.out.println("Can not insert employee.");}	
    }	

    public void showAll(){
    		for(int i=0;i<branches.length;i++){
    			if(branches[i] != null){
    				branches[i].showAllDetails();
    			}
    		}
    }	
    public String getAllBranchAsString(){
    	String s = "";
    		for(int i=0;i<branches.length;i++){
    			if(branches[i] != null){
    				s+=branches[i].getBranchAsString()+"\n";
    			}
    		}
    		return s;	
    }

	public Branch [] getAllBranchesArray(){
		return branches;
	}
	
		
		
}
