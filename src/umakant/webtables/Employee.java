package umakant.webtables;

public class Employee implements Comparable<Employee> {
	String name;
	int age;
	String position;
	String office;
	String startDate;
	String salary;

	public Employee(String name,  String position, String office,int age, String startDate, String salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.office = office;
		this.startDate = startDate;
		this.position = position;
	}

	@Override
	public int compareTo(Employee o) {
		return this.age - o.age;
	}

	

	public boolean equals(Object o) {
		Employee e = (Employee) o;
		if (this.name.equals(e.name) && this.age == e.age && this.position.equals(e.position)
				&& this.office.equals(e.office) && this.startDate.equals(e.startDate) && this.salary.equals(e.salary))
			return true;
		return false;
	}
	
	public int hashCode() {
		char[] chars = name.toCharArray();
		int sum = 0;
		for (char ch : chars)
			sum += ch;
		return sum;
	}

	public String toString() {
		return name + "-" + age;
	}

}
