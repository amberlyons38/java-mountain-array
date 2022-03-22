import java.util.InputMismatchException;
import java.util.Scanner;

public class MountainArray {
    public boolean validMountainArray(int[] arr) {
        int inAmt = 0;
        int deAmt = 0;
        
        int pos = 0;
        
        if(arr.length >= 3){
            while(pos < arr.length - 1 && arr[pos] < arr[pos + 1]){
                inAmt++;
                pos++;
            }
            
            while(pos < arr.length - 1 && arr[pos] > arr[pos + 1]){
                deAmt++;
                pos++;
            }
            
            return deAmt > 0 && inAmt > 0 && inAmt + deAmt == arr.length - 1;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;
        
        try{
            System.out.println("Enter the array length: ");
            length = in.nextInt();
            while(length >= Math.pow(10, 4)){
                System.out.println("Array length too large, please re-enter a smaller array length: ");
                length = in.nextInt();
            }
        }catch(InputMismatchException ex){
            System.out.println("Invalid Input: Array length must be an integer.");
        }
        
        int[] arr = new int[length];
        
        for(int i = 0; i < length; i++){
            System.out.println("Enter an integer for element "+i+": ");
            try{
                arr[i] = in.nextInt();
            }catch(InputMismatchException ex){
                System.out.println("Invalid Input: Array elements can only be integers.");
            }
        }
        
        MountainArray ma = new MountainArray();
        
        if(ma.validMountainArray(arr) == true){
            System.out.println("Array is a valid mountain array.");
        }
        else{
            System.out.println("Array is not a valid mountain array.");
        }
    } 
}
