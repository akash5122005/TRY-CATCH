import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            int size = scanner.nextInt();
            int[] array = new int[size];
            for(int i=0; i < size; i++){
                array[i] = scanner.nextInt();
            }
            int index = scanner.nextInt();
            System.out.println("The element at index " + index + " is: "+ array[index]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Index out of bounds.");
        } finally {
            scanner.close();
        }
    
    }
}
