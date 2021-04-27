package myjava.serialization;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -9222640742105114065L;

	private String name;
	private int id;
	transient private int salary;

	public Employee(String name)
	{
		this.name = name;
	}

	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private Object readResolve() {
		// The readResolve method is called when objectInputStream has read an object from the stream and
		// is preparing to return it to the caller
		System.out.println("Executing readResolve");
		System.out.println(this.hashCode());
		System.out.println(this.toString());
		return this;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary
			   + ", serialVersionUID" + serialVersionUID + "]";
	}
}
