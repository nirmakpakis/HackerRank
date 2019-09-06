
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int numberOfSwaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if((i+1) != arr[i]){
                map.put(arr[i],i);
            }
        }
        for(int i=0; i<arr.length; i++){
            if((i+1) != arr[i]){
                int index = map.get(i+1);
                map.replace(arr[i], index); 
                swap(index,i,arr);
                numberOfSwaps++;
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        return numberOfSwaps;
    }

    static void swap(int index, int i, int[] arr){
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
