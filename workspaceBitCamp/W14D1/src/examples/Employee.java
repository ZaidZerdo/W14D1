package examples;

public class Employee {
	private Integer id;
	private String name;
	private Integer salary;
	
	public Employee(Integer id, String name, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getSalary() {
		return salary;
	}



	public void setSalary(Integer salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return name + "(" + id + "): " + salary + " KM";
	}
	
}
