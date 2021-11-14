package akansha_Jain.Assignment_13;

public class Employee implements Comparable<Employee> {
	String name;
	String position;
	String office;
	int age;
	String startDate;
	String salary;
	
	public Employee(String name, String position, String office, int age, String startDate, String salary) {
		this.name = name;
		this.position = position;
		this.office = office;
		this.age = age;
		this.startDate = startDate;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return this.age - o.age;
	}
	
	@Override
	public String toString() {
		return name + " - " + age;
	}
	
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		if (this.name.equals(e.name) && this.position.equals(e.position) && this.office.equals(e.office)
				&& this.age == e.age && this.startDate.equals(e.startDate) && this.salary.equals(e.salary))
			return true;
		return false;
	}
}