package com.nikhil.main;

public class OddClass implements Runnable{
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i += 2) {
			System.out.println("Odd class object printing "+ i);
		}
	}

}
