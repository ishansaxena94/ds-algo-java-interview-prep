package myjava.threads;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<String> {

	static int count = 0;

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return (Thread.currentThread().getName() + "\tTask " + count++);
	}

}
