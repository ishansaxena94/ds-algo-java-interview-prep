package myjava.singleton;

public enum EnumSingleton
{
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public void doSomething(){
        System.out.println("Doing Stuff");
    }
}
