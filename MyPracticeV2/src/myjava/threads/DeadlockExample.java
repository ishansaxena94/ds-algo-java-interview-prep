package myjava.threads;

public class DeadlockExample {

	static String s1 = "";
	static String s2 = "a";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(() -> {

			synchronized (s1) {
				System.out.println(Thread.currentThread().getName() + " Acquired lock on s1");

				synchronized (s2) {
					System.out.println(Thread.currentThread().getName() + " Acquired lock on s2");
				}
			}
		});

		Thread t2 = new Thread(() -> {

			synchronized (s2) {
				System.out.println(Thread.currentThread().getName() + " Acquired lock on s2");

				synchronized (s1) {
					System.out.println(Thread.currentThread().getName() + " Acquired lock on s1");
				}
			}
		});

		t1.start();
		t2.start();
	}

}
