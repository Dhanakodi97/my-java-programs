package samplePrograms;

import java.util.Scanner;

public class Sample2 {
	
		public static void main(String []argh) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();

	        for (int i = 0; i < t; i++) {
	            try {
	                long x = sc.nextLong();  // Read the long integer

	                System.out.println(x + " can be fitted in:");

	                // Check if the number can fit into byte, short, int, long
	                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
	                    System.out.println("* byte");
	                    System.out.println(Byte.MIN_VALUE);
	                }
	                if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
	                    System.out.println("* short");
	                }
	                if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
	                    System.out.println("* int");
	                }
	                // If it's not fitting in any smaller types, it will always fit in long
	                if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
	                    System.out.println("* long");
	                }

	            } catch (Exception e) {
	                // If an exception occurs (e.g., input is too large to fit into a long), print the message
	                System.out.println(sc.next() + " can't be fitted anywhere.");
	            }
	        }
	    }

}
