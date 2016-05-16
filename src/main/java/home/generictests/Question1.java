package home.generictests;

public class Question1 {
	
//	public static void JavaHungry(Exception e) {
//		System.out.println("Exception");
//	}
	
//	public static void JavaHungry(ArithmeticException e) {
//		System.out.println("ArithmaticException");
//	}
	
	public static void JavaHungry(Object  e) {
		System.out.println("Object");
	}
	
	
	public static void JavaHungry(String e) {
		System.out.println("String");
	}
	
	/*
	public static void JavaHungry(Exception e) {
		System.out.println("Exception");
	}

	*/
	
	public static void main(String[] args) {
		JavaHungry(null);

	}

}
