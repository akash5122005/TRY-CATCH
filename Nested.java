import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();
        int[] array = new int[5];

        for(int i = 0; i < 5; i++){
            array[i] = scanner.nextInt();
        }

        int index = scanner.nextInt();
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();

        try{

            try(Scanner fileScanner = new Scanner(new File(filePath))){
                System.out.println("File content:");
                while(fileScanner.hasNextLine()){
                    System.out.println(fileScanner.nextLine());
                }
            } catch(FileNotFoundException e){
                System.out.println("Error: File not found.");
            }

            try{
                System.out.println("Value at index " + index + ": " + array[index]);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: Index " + index + " is out of bounds.");
            }

            try {
                int result = numerator / denominator;
                System.out.println("Result: "+result);
            } catch(ArithmeticException e){
                System.out.println("Error: Division by zero is not allowed.");
            }
        } finally {
            scanner.close();
        } 
    }
}
