package com.java.practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInputFromConsole {
	public static void main(String[] args) throws IOException {

		String name = "";
		int age = 0;
		System.out.println("Please enter your choice to go for which type of input reader method:");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "B":
			// 1. To read Input from the keyboard using BufferedReader
			System.out.println("--------------------Reading i/p Using bufferedReader Classic");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter your name:");
			name = bufferedReader.readLine();
			System.out.println("name: " + name);
			System.out.println("Please enter your age:");
			try {
				age = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Age: " + age);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "S":
			// 2. To read input from Scanner Java1.5
			System.out.println("--------------------Reading i/p Using Scanner Java 1.5 onwards");
			//Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter your name:");
			name = scanner.nextLine();
			System.out.println("name: " + name);
			System.out.println("Please enter your age:");
			try {
				age = Integer.parseInt(scanner.nextLine());
				System.out.println("Age: " + age);
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;

		case "C":
			// 3. To read input from system.console 1.6+
			System.out.println("--------------------Reading i/p Using System.Console Java 1.6 onwards");
			System.out.println("Please enter your name:");
			name = System.console().readLine();
			System.out.println("name: " + name);
			System.out.println("Please enter your age:");
			try {
				age = Integer.parseInt(System.console().readLine());
				System.out.println("Age: " + age);
			} catch (Exception e) {
				// TODO: handle exception
			}

			break;

		default:
			System.out.println("Please enter the valid option!!!");
			break;
		}
		scanner.close();
	}
}
//In eclipse we can't use Scanner to read the value. We need to run from from the command prompt.