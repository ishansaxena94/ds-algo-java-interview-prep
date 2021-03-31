package myjava.threads;

import java.util.LinkedList;

public class ProducerConsumerSynchronized {

	LinkedList<Integer> list = new LinkedList<Integer>();
	int capacity = 2;

	public void produce() throws InterruptedException {

		int value = 0;

		while (true) {

			synchronized (this) {

				if (list.size() == capacity)
					wait();

				System.out.println(Thread.currentThread().getId() + ": Produced - " + value);
				list.add(value++);

				// wake up consumer thread
				notify();
			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {

			synchronized (this) {

				if (0 == list.size())
					wait();

				System.out.println(Thread.currentThread().getId() + ": Consumed - " + list.removeFirst());

				notify();
			}

		}
	}

}
