package com.nikhil.main;

import com.nikhil.demo.ChildClass;

public class RelationShipDemo {

	public static void main(String[] args) {
		/*
		 * In this program, we have a Parent class with a parameterless constructor that
		 * simply prints a message indicating that the parent constructor is invoked.
		 * The Child class extends the Parent class and has its own constructor. Inside
		 * the Child constructor, we call the super() statement, which invokes the
		 * parent class constructor explicitly.
		 * 
		 * In the RelationShipDemo class, we create an instance of the Child class by
		 * calling new Child(). When we run the program, it will output:
		 * 
		 */
		System.out.println("We want to be able to invoke the parent constructor when child object is created");

//		ChildClass child = new ChildClass();
		new ChildClass();
		System.out.println(
				"since super() can't be placed below the sysout statment, parent class constructor will be first to be printed in the console");

		/*
		 * KEYPOINTS: CONSTRUCTOR
		 * 
		 * Constructors are special methods in a class that are used to initialize
		 * objects of that class. They have the same name as the class and do not have a
		 * return type, not even `void`.
		 * 
		 * Constructors are automatically invoked when an object of a class is created
		 * using the `new` keyword. They ensure that the object is properly initialized
		 * before it can be used.
		 * 
		 * Like regular methods, constructors can be overloaded. This means a class can
		 * have multiple constructors with different parameters, allowing objects to be
		 * initialized in different ways.
		 * 
		 * If a class does not explicitly define any constructors, Java provides a
		 * default constructor with no parameters. It initializes member variables to
		 * their default values (e.g., `0` for numeric types, `null` for reference
		 * types). Else, it uses the constructor from the Object class.
		 * 
		 * Constructors can have access modifiers (`public`, `private`, `protected`, or
		 * default) to control their visibility. This determines whether they can be
		 * accessed by other classes or only within the same package.
		 * 
		 * If a constructor does not explicitly invoke another constructor using
		 * `this()` or `super()`, the compiler inserts a call to the default
		 * (parameterless) constructor of the superclass (`super()`), or the call to
		 * another constructor in the same class (`this()`), as the first statement of
		 * the constructor.
		 * 
		 * A constructor in a subclass must either call a constructor in the superclass
		 * using `super()`, or the superclass must have a default constructor. If
		 * neither condition is met, the compiler will throw an error.
		 * 
		 * Constructors can call other constructors in the same class using `this()` for
		 * constructor chaining. This allows one constructor to reuse the code of
		 * another constructor in the same class.
		 * 
		 * Constructors accept parameters that are used to initialize the instance
		 * variables of an object. These parameters help customize the object's initial
		 * state during creation.
		 * 
		 */
	}
}
