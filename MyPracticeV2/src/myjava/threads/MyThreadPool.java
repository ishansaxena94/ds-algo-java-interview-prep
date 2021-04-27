package myjava.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

	private final int capacity;
	private final WorkerThread[] threads;
	private BlockingQueue<Runnable> queue;
	static volatile Object lock;

	public MyThreadPool(int size) {
		capacity = size;
		threads = new WorkerThread[size];
		queue = new ArrayBlockingQueue<Runnable>(size);
		lock = new Object();

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (lock) {

			while (queue.size() == capacity) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			queue.add(task);
			System.out.println("Added task " + task.toString());
			lock.notifyAll();
		}
	}

	private class WorkerThread extends Thread {

		@Override
		public void run() {

			Runnable task;
			System.out.println(Thread.currentThread().getName() + " is Running");
			while (true) {
				synchronized (lock) {

					while (queue.isEmpty()) {
						try {
							System.out.println(Thread.currentThread().getName() + " | Waiting");
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					task = queue.poll();

					if (null != task) {
						System.out.print("Thread : " + Thread.currentThread().getName());
						task.run();

						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
