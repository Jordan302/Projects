/**
 * Write a short program that prints each number from 1 to 100 on a new line. 
 *
 * For each multiple of 3, print "Fizz" instead of the number. 
 *
 * For each multiple of 5, print "Buzz" instead of the number. 
 *
 * For numbers which are multiples of both 3 and 5, print "FizzBuzz" instead of the number.
 */ 
 
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        for (int num = 1; num <= 100; num++) {
            if (num % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (num % 3 == 0) {
                System.out.println("Fizz");
            } else if (num % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num);
            }
        }
    }
}
