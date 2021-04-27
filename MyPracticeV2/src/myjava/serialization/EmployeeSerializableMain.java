package myjava.serialization;

import java.io.*;

public class EmployeeSerializableMain {

	public static void main(String[] args) {

		Employee emp = new Employee("Pankaj");
		emp.setId(1);
		emp.setSalary(100);

		System.out.println(emp);
		System.out.println(emp.hashCode());

		serialize(emp);
		deserialize();
	}

	private static void deserialize()
	{
		try {
			FileInputStream is = new FileInputStream("EmployeeObject.ser");
			ObjectInputStream ois = new ObjectInputStream(is);

			// read file to object
			Employee emp = (Employee) ois.readObject();
			System.out.println("Deserialization Done");
			System.out.println(emp.toString());
			System.out.println(emp.hashCode());

			// closing resources
			ois.close();
			is.close();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void serialize(Employee emp){
		try {
			FileOutputStream fos = new FileOutputStream("EmployeeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// write object to file
			oos.writeObject(emp);
			System.out.println("Serialization Done");

			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
