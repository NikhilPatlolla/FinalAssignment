package com.nikhil.polymorphism;

public class Rectangle implements Shape {
	
	private double bredth;
	private double length;
	

	public Rectangle(double lenght, double bredth) {
		this.length = lenght;
		this.bredth = bredth;
	}


	@Override
	public double calculatePerimeter() {
		return 2 * (length + bredth);
	}
	
	
}
