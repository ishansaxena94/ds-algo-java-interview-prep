package utils;

import myjava.serialization.Employee;

import java.io.*;

public class SerDesUtils
{
    public static Object deserialize()
    {
        Object o = null;

        try {
            FileInputStream is = new FileInputStream("MyObject.ser");
            ObjectInputStream ois = new ObjectInputStream(is);

            // read file to object
            o = ois.readObject();
            System.out.println("Deserialization Done");

            // closing resources
            ois.close();
            is.close();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return o;
    }

    public static void serialize(Object o){
        try {
            FileOutputStream fos = new FileOutputStream("MyObject.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // write object to file
            oos.writeObject(o);
            System.out.println("Serialization Done");

            // closing resources
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
