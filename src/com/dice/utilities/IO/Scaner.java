package com.dice.utilities.IO;

import java.util.Scanner;

public class Scaner {
	private static Scanner scaner;
	
	public Scaner() {
		Scaner.scaner = new Scanner(System.in);
	}

	public static Scanner getScaner() {
		return scaner;
	}

	public static void setScaner(Scanner scaner) {
		Scaner.scaner = scaner;
	}
	
}
