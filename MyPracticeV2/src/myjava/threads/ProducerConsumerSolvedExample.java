package myjava.threads;

public class ProducerConsumerSolvedExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProducerConsumerSynchronized pc = new ProducerConsumerSynchronized();

		Thread producer = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		producer.start();
		consumer.start();

	}

}