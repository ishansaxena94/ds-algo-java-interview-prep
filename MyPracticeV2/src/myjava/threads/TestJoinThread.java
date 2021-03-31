package myjava.threads;

public class TestJoinThread implements Runnable {

	// The join() method waits for a thread to die. In other words, it causes the
	// currently running threads to stop executing until the thread it joins with
	// completes its task.

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new TestJoinThread());
		Thread t2 = new Thread(new TestJoinThread());
		Thread t3 = new Thread(new TestJoinThread());

		t1.start(); // main is paused until t1 finishes

		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
		t3.start();
	}

}
