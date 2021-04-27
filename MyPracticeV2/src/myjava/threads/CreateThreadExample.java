package myjava.threads;

public class CreateThreadExample {

	public static void main(String[] args) {

		Runnable r1 = () -> {

			System.out.println("Hello");
			System.out.println("Th: " + Thread.currentThread().getId());
			System.out.println("Run: " + Thread.currentThread().getName());

		};

		Thread t1 = new Thread(r1);
		//t1.setDaemon(true);

		t1.start();

		System.out.println("main: " + Thread.currentThread().getName());
		System.out.println("Main " + Thread.currentThread().getId());

		/*
		 * Following statement will give error as we cannot start a thread twice:
		 * java.lang.IllegalThreadStateException at java.lang.Thread.start(Unknown
		 * Source) at
		 * myjava.threads.CreateThreadExample.main(CreateThreadExample.java:21)
		 */
		t1.start();
	}

}
