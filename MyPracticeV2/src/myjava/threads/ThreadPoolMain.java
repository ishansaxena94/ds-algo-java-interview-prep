package myjava.threads;

public class ThreadPoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThreadPool threadpool = new MyThreadPool(10);

		for (int i = 0; i < 20; i++) {
			Task task = new Task("Task #" + i);
			threadpool.execute(task);
		}

	}

}
