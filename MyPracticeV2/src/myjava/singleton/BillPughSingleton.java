package myjava.singleton;

public class BillPughSingleton
{
    // https://dzone.com/articles/singleton-in-java

    private BillPughSingleton(){};

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    /*
    Notice the private inner static class that contains the instance of the singleton class.
    When the singleton class is loaded, SingletonHelper class is not loaded into memory and
    only when someone calls the getInstance method,
    this class gets loaded and creates the Singleton class instance.

    This is the most widely used approach for Singleton class as it doesn’t require synchronization

    -----
    In this method is based on the Java Language Specifications (JLS).
    Java Virtual Machine loads static data-members only on-demand.
    So, here the class SingletonClass loads at first by the JVM. Since there is no static data memberin the class;
    SingletonClassHolder does not loads or creates SINGLE_INSTANCE.

    This will happen only when we invoke getInstance method.
    JLS guaranteed the sequential execution of the class initialization; that means thread-safe.
    So, we actually do not need to provide explicit synchronization on static getInstance() method for loading and initialization.
    Here, since the initialization creates the static variable SINGLE_INSTANCE in a sequential way,
    all concurrent invocations of the getInstance() will return the same correctly initialized SINGLE_INSTANCE without synchronization overhead.
     */
}
