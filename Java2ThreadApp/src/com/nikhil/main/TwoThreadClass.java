package com.nikhil.main;

public class TwoThreadClass {

	public static void main(String[] args) {
		Thread evenThread = new Thread(new EvenClass());
		Thread oddThread = new Thread(new OddClass());
		
		//starting each thread using start() method
		evenThread.start();
		oddThread.start();
	}
}
