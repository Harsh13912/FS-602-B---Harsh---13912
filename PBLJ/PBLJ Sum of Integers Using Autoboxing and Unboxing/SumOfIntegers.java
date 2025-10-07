import java.util.ArrayList;
import java.util.Scanner;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers separated by spaces:");

        // Read entire line of input as a string
        String input = scanner.nextLine();

        // Split the input string into tokens by spaces
        String[] tokens = input.split("\\s+");

        // Parse strings to Integers and add to the list (autoboxing happens here)
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token); // parse string to primitive int
                numbers.add(num); // autoboxing: int -> Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer input skipped: " + token);
            }
        }

        // Calculate sum using unboxing (Integer -> int)
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;  // unboxing happens here
        }

        System.out.println("Sum of the integers: " + sum);
        
        scanner.close();
    }
}
