package org.example;
//  RandomGenerator.java

import java.util.Random;

class RandomGenerator {

/**
 * creates a random number ranging between lo and hi,  
 * @param lo
 * @param hi
 * @return
 */
	static int discrete(int lo, int hi)
	{
		if(lo >= hi){
			System.out.println("Error discrete, lo >= hi");
			System.exit(0);
		}
		
		Random r = new Random();
		int d = r.nextInt(hi - lo + 1) + lo;
		return d;
	}

	public static void main(String[] args) {
		System.out.println(discrete(0,2));
	}
	
}
