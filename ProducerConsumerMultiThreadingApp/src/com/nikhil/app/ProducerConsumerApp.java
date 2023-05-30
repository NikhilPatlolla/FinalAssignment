package com.nikhil.app;

import java.util.LinkedList;
import java.util.Queue;

import com.nikhil.consumer.ConsumerClass;
import com.nikhil.producer.ProducerClass;

public class ProducerConsumerApp {
	public static final int LENGTH = 15;

	// the program would never end if we do not decide the no of times the
	// producerClass will add values to the queue, here it is 50
	public static final int MAX_NUMBERS = 50;

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		ProducerClass producerClass = new ProducerClass(queue);
		ConsumerClass consumerClass = new ConsumerClass(queue, producerClass);

		Thread prodThread = new Thread(producerClass);
		Thread custThread = new Thread(consumerClass);

		System.out.println("\n\nStarting the application\n\n*******************");

		prodThread.start();
		custThread.start();

		try {
			// main thread waits till the end of the execution of the threads before the
			// main method closes.
			prodThread.join();
			custThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n*************************\n\nClosing the application");

	}

}
