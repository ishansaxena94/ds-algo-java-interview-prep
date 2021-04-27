package myjava.singleton;

import utils.SerDesUtils;

public class SingletonMain
{
    public static void main(String[] args)
    {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());

        singleton.doSomething();

        // -----------------------------------------------------------

        System.out.println("\n---------- MySingleton ----------");
        MySingleton mySingleton = MySingleton.getInstance();
        mySingleton.i = 10;
        SerDesUtils.serialize(mySingleton);
        mySingleton.i = 15;

        MySingleton mySingleton2 = (MySingleton)SerDesUtils.deserialize();

        System.out.println("mySingleton hash: " + mySingleton.hashCode());
        System.out.println("mySingleton2 hash: " + mySingleton2.hashCode());
        System.out.println("mySingleton2 i: " + mySingleton2.i);

        // CLONE
        try
        {
            mySingleton.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
