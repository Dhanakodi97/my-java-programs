package interviewProgram;

//public class PalindromeCheck {
//
//	public static void main(String[] args) {
//		int num = 124;
//        int original = num, reversed = 0;
//
//        while (num != 0) {
//            int digit = num % 10;
//            reversed = reversed * 10 + digit;
//            num /= 10;
//        }
//
//        if (original == reversed) {
//            System.out.println("Palindrome");
//        } else {
//            System.out.println("Not a Palindrome");
//        }
//
//	}
//
//}
import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int original = num, reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        if (original == reversed) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}
