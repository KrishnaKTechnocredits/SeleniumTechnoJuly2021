package bhakti;

import java.util.ArrayList;

public class Employee {
	
	String ID;
	String First_Name;
	String Last_Name;
	String Username;
	
	
	Employee(String ID,String First_Name, String Last_Name, String Username  ){
		this.ID=ID;
		this.First_Name= First_Name;
		this.Last_Name= Last_Name;
		this.Username= Username;
	}
	
	@Override
	public String toString() {
		return this.ID +" "+this.First_Name+ " "+this.Last_Name+" "+this.Username;
	}

	 
	

}
