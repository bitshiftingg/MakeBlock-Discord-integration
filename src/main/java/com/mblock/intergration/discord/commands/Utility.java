package com.mblock.intergration.discord.commands;

import java.util.Random;

public class Utility {
	
	
	public static int exclusiveRandom(int min, int max) {
		if (max <= min) {
			max = min + 1;
		}
		return RANDOM.nextInt((max - min)) + min;
	}
	
	/** Random instance, used to generate pseudo-random primitive types. */
	public static final Random RANDOM = new Random(System.currentTimeMillis());

}
