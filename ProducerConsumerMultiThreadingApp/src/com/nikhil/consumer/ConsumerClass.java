package com.nikhil.consumer;

import java.util.Queue;

import com.nikhil.producer.ProducerClass;

public class ConsumerClass implements Runnable {
	private Queue<Integer> queue;
	private ProducerClass producer;

	public ConsumerClass(Queue<Integer> queue, ProducerClass producer) {
		this.queue = queue;
		this.producer = producer;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					if (producer.isProductionComplete()) {
						return;
					}
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

//				if (queue.isEmpty()) {
//					return;
//				}

				if (!queue.isEmpty()) {
					Integer queueVal = queue.poll();
					System.out.println("Consumer accepted value " + queueVal);

					queue.notifyAll();
				}

			}
		}

	}
}
