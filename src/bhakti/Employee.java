package bhakti;

public class Employee implements Comparable<Employee> {

	String name;
	String position;
	String office;
	String  age;
	String start_date;
	String salary;
	public Employee(String name, String position, String office, String age, String start_date, String salary) {
		 
		this.name = name;
		this.position = position;
		this.office = office;
		this.age = age;
		this.start_date = start_date;
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee o) {
		 return this.age.compareTo(o.age);
	}
	@Override
	public String toString() {
		return this.name +	this.position +this.office +this.age+this.start_date +this.salary;
	}
	
	

}
