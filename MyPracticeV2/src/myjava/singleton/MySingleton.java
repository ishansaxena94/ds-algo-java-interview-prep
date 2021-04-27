package myjava.singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class MySingleton implements Serializable, Cloneable
{
    private static final long serialVersionUID = 0L;
    int i = 0;

    // 1. Private static variable of the same class that is the only instance of the class.
    // 2. Volatile so threads no cache value
    private static volatile MySingleton mySingleton;

    // 3. Private constructor to restrict instantiation of the class from other classes.
    private MySingleton() {
        if (mySingleton != null) {
            throw new IllegalStateException("Singleton already constructed");
        }
    }

    // 4. Public static method that returns the instance of the class,
    // this is the global access point for outer world to get the instance of the singleton class.
    public static MySingleton getInstance(){

        if(null == mySingleton){

            // synchronized block
            synchronized (MySingleton.class){

                // double null check
                if(null == mySingleton){
                    mySingleton = new MySingleton();
                }
            }
        }

        return mySingleton;
    }

    // It can break if the class is Serializable. Soln. Implement readResolve method. Not working TODO
    // It can break if its 'Clonable' Soln. Override clone Method
    // You can break by Reflection. Soln. Check in private cons, Enums

    protected Object readResolve() {
        System.out.println("Inside readResolve");
        return getInstance();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
    {
        ois.defaultReadObject();
        mySingleton = this;
    }

    private Object writeReplace() throws ObjectStreamException {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
    }
}
