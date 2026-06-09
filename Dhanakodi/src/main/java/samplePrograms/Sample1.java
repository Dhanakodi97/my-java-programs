package samplePrograms;

import java.util.Comparator;
import java.util.Scanner;

public class Sample1 {
	public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        Comparator<T> comp = new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
        int t = in.nextInt();  // Read the number of test cases
        
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();  // Read the starting number (a)
            int b = in.nextInt();  // Read the number to add (b)
            int n = in.nextInt();  // Read the number of terms (n)
            System.out.println("the minimum value of byte is : " + Byte.MIN_VALUE);

            // Generate the sequence and print the terms
            int sum = a;  // Start with the value of a
            for (int j = 0; j < n; j++) {
                // Add the current value of b to the sum and print it
                sum += b * (1 << j);  // 1 << j is equivalent to 2^j
                System.out.print(sum + " ");  // Print the current term in the sequence
            }
            System.out.println();  // Move to the next line after each test case
        }
        
        in.close();
    }

}
