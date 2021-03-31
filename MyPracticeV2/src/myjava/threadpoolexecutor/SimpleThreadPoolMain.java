package myjava.threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPoolMain {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		Runnable worker;

		for (int i = 0; i < 10; i++) {
			worker = new WorkerThread("" + i);
			executor.execute(worker);
		}

		executor.shutdown();
		while (!executor.isTerminated())
			;
		System.out.println("Finished all threads");
	}

}
