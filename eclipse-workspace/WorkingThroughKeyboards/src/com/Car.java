package com;

public class Car {
	int wheel=4;
	String color="Blue";
	float price= 23;	
	
	void start() {
		System.out.println("Cart Started...");
	}
	void appliedGear() {
		System.out.println("Applied Gear");
	}
	void moving() {
		System.out.println("Car is moving");
	}
	void stop() {
		System.out.println("Car Stop");
	}
	
	void displayCarDetails() {
		String info="Car Info";			// local variable 
		System.out.println("Wheel "+wheel);
		System.out.println("Color "+color);
		System.out.println("Price "+price);
		System.out.println(info);
	}
	public static void main(String[] args) {
		
	 Car Nissan = new Car(); 
	 Nissan.displayCarDetails();
	 Nissan.stop();
	 
	}
		}
	
