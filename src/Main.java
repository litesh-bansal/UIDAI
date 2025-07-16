import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> allPeople = new ArrayList<>();
        File jsonFile = new File("people.json");
        ObjectMapper mapper = new ObjectMapper();

        
        if (jsonFile.exists() && jsonFile.length() > 0) {
            try {
                allPeople = mapper.readValue(jsonFile, new TypeReference<List<Person>>() {});
                System.out.println("Existing data loaded from people.json");
            } catch (IOException e) {
                System.err.println("❌ Error reading existing data from people.json: " + e.getMessage());
                System.err.println("Starting with an empty list for new data.");
                
            }
        }

        int N = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter how many persons you want to add:");
            try {
                N = scanner.nextInt();
                if (N < 0) {
                    System.out.println("⚠️ Number of persons cannot be negative. Please enter a positive number.");
                    scanner.nextLine(); // Consume the invalid input
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number for the count.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume the leftover newline after nextInt()

        for (int i = 0; i < N; i++) {
            System.out.println("\n--- Entering details for Person " + (i + 1) + " ---");

            String name = "";
            validInput = false;
            while (!validInput) {
                System.out.print("Name: ");
                name = scanner.nextLine();
                if (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty.");
                } else {
                    validInput = true;
                }
            }

            int age = 0;
            validInput = false;
            while (!validInput) {
                System.out.print("Age: ");
                try {
                    age = scanner.nextInt();
                    if (age < 0) { 
                        System.out.println("Please enter a valid age.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number for age.");
                } finally {
                    scanner.nextLine(); 
                }
            }

            double balance = 0.0;
            validInput = false;
            while (!validInput) {
                System.out.print("Balance: ");
                try {
                    balance = scanner.nextDouble();
                    if (balance < 0) { // Example balance validation
                        System.out.println("⚠️ Balance cannot be negative. Please enter a non-negative value.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Invalid input. Please enter a valid number for balance (e.g., 400.00).");
                } finally {
                    scanner.nextLine(); // Always consume the leftover newline
                }
            }

            System.out.print("Enter interests separated by commas (e.g., reading,gaming,sports): ");
            String interestInput = scanner.nextLine();
           
            List<String> interests = Arrays.asList(interestInput.split("\\s*,\\s*"));

            Person person = new Person(name, age, balance, interests);
            allPeople.add(person);
        }

      
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, allPeople);
            System.out.println("\n✅ Successfully saved all data (including new entries) to: " + jsonFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving data to people.json: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            scanner.close();
        }
    }
}
