import java.util.Scanner;
public class TipCalculator{
	public static void main(String [] args){

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Tip Calculator!");
        System.out.println();
		System.out.println("Enter the prices of your items. Enter -1 to enter tip percentage.");
		int count = 1;
		double price = 0.0;
		double subtotal = 1.0;

		while(price != -1){
			System.out.print("Item " + count + ": $");
		    price = scan.nextDouble();
		    count ++;
		    subtotal += price;
		}
		
		System.out.println();
		System.out.print("Enter the tip percentage:");
        double percentage = scan.nextDouble();
        double tip = subtotal * percentage;
		double total = subtotal + tip; 
		System.out.println();
		System.out.printf("Subtotal: $%.2f%n", subtotal);
		System.out.printf("Tip:      $%.2f%n", tip);
		System.out.printf("Total:    $%.2f%n", total);
	}
}
