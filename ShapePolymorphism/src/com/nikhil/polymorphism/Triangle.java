package com.nikhil.polymorphism;

public class Triangle implements Shape {

	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	@Override
	public double calculatePerimeter() {
		return sideA + sideB + sideC;
	}

}
