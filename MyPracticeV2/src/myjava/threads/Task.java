package myjava.threads;

public class Task implements Runnable {

	final String someTask;

	Task(String str) {
		someTask = str;
	}

	@Override
	public void run() {
		System.out.println("| Executing: " + someTask);

	}

	@Override
	public String toString() {
		return "Task [someTask=" + someTask + "]";
	}

}
