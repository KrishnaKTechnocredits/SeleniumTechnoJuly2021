package husain.Assignment13;

public class SortData implements Comparable {
	String name;
	String position;
	String office;
	int age;
	String startDate;
	String salary;

	public SortData(String name, String position, String office, String age, String startDate, String salary) {
		this.name = name;
		this.position = position;
		this.office = office;
		this.age = Integer.parseInt(age);
		this.startDate = startDate;
		this.salary = salary;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		SortData obj = (SortData) o;
		return this.age - obj.age;
	}
	
	/*
	 * public boolean equals(SortData obj) { if(this.name.equals(obj.name) &&
	 * this.position.equals(obj.position) && this.age == obj.age &&
	 * this.startDate.equals(obj.startDate) && this.salary.equals(obj.salary))
	 * return true; return false;
	 * 
	 * }
	 */

	public String toString() {

		return name + " " + position + " " + office + " " + age + " " + startDate + " " + salary;
	}

}
