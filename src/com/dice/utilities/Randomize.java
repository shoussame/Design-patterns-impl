package com.dice.utilities;

import java.util.Random;

public class Randomize {
	public static int getNumber () {
		Random number = new Random();
		return number.nextInt(6) + 1;
	}
}
