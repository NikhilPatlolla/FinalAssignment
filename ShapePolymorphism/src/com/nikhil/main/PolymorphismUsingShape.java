package com.nikhil.main;


import com.nikhil.polymorphism.Circle;
import com.nikhil.polymorphism.Rectangle;
import com.nikhil.polymorphism.Shape;
import com.nikhil.polymorphism.Square;
import com.nikhil.polymorphism.Triangle;

public class PolymorphismUsingShape {

	public static void main(String[] args) {
		/*
		 * In this updated version, the Shape interface remains the same. The shape classes Rectangle, Square, Triangle, and Circle still implement the Shape interface. 
		 * However, when creating instances of these shapes, we assign them to variables of the Shape type. This allows us to utilize polymorphism.

			By treating all shape objects as instances of the Shape interface, we can invoke the calculatePerimeter() method on each object without needing to know the specific shape. 
			This enables us to write more flexible and scalable code, as we can easily add new shapes that implement the Shape interface without modifying the code that uses these shapes.
		 * 
		 * 
		 * */
		System.out.println("An interface by the name shape is created with the respective fields needed to calculate perimeter");
		
		Shape rectangle = new Rectangle(4,6);
		System.out.println("Rectangle permiter: "+ rectangle.calculatePerimeter());
		Shape square = new Square(4);
		System.out.println("square permiter "+ square.calculatePerimeter());
		Shape triangle = new Triangle(4,5,6);
		System.out.println("traingle permiter "+ triangle.calculatePerimeter());
		Shape circle = new Circle(4);
		System.out.println("circle permiter "+ circle.calculatePerimeter());
	}

}
