package com;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	
	static Scanner sc = new Scanner(System.in);
	public static void display() {
		System.out.println("Press 1 to print all file in current list");
		System.out.println("Press 2 for file operation");
		System.out.println("Press 3 to logout");
	}

	public static void main(String[] args) {
		System.out.println("Kwofie Ecosystem");
		System.out.println("Richard Kwofie, Vodafone Ghana");

		
		File[] fileList;
	   Label_main_menu:
		while(true) {
		
			display();
			System.out.println("Enter a number 1 - 3");
			try { int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("List directory content in ascending order!");
				fileList = new File(System.getProperty("user.dir")).listFiles();
				Arrays.sort(fileList);
				for(File f: fileList) {
					System.out.println(f.getName());
				}
				
				break;
				
			case 2:
				FileOperations.fileOperationsPrompt();
				break;
				
			case 3:
				System.out.println("Logout");
				break Label_main_menu;
				
				default:
					System.out.println("Please choose between 1 to 3");
					
			}
			} catch (Exception e) {
				System.out.println("Please make sure to choose a number between 1 to 3");
				
				sc.next();
			}
		}
	}

	}



