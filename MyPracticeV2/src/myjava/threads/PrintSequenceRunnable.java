package myjava.threads;

public class PrintSequenceRunnable implements Runnable {

	int remainder;
	static volatile Integer counter = 1;
	static Object lock = new Object();

	public PrintSequenceRunnable(int r) {
		remainder = r;
	}

	@Override
	public void run() {

		while (counter < 10) {
			// System.out.println("At " + Thread.currentThread().getName());

			synchronized (lock) {
				while (counter % 3 != remainder) {
					try {
						System.out.println(Thread.currentThread().getName() + "| Give up lock & wait ");
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("*From wait: " + Thread.currentThread().getName());
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + "| Num: " + counter);
				counter++;

				System.out.println(Thread.currentThread().getName() + "| notify ");
				try {
					lock.notifyAll();
				} catch (Exception e) {
					System.out.println("---------------");
					System.out.println("From notify: " + Thread.currentThread().getName());
					e.printStackTrace();
					System.out.println("---------------");
				}
			}
		}
	}

}
