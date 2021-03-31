package myjava.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		FutureTask<CallableExample>[] tasks = new FutureTask[5];

		CallableExample callable;
		Thread t;

		for (int i = 0; i < 5; i++) {
			callable = new CallableExample();
			tasks[i] = new FutureTask(callable);

			t = new Thread(tasks[i]);
			t.start();
		}

		System.out.println("Getting results");
		for (int i = 0; i < 5; i++) {
			System.out.println(tasks[i].get());
		}

		// ExecutorService
		ExecutorService executor = Executors.newFixedThreadPool(10);

		List<Future<String>> list = new ArrayList<>();

		Callable c = new CallableExample();

		for (int i = 0; i < 100; i++) {
			Future<String> future = executor.submit(c);
			list.add(future);
		}

		for (Future<String> fut : list) {
			try {
				System.out.println(fut.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();

	}

}
