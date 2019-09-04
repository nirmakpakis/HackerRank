import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        boolean sorted = false;
        int[] numberOfBribes = new int[q.length];
        fillWithZeros(numberOfBribes);
        while(!sorted){
            for(int i= q.length-1; i>0; i--){
                if(q[i]<q[i-1]){
                    swap(q,i,i-1);
                    numberOfBribes[q[i]-1] += 1;
                    if(numberOfBribes[q[i]-1]>2){
                        System.out.println("Too chaotic");
                        return;
                    }
                }
            }
            sorted = checkSorted(q);
        }
        System.out.println(getSum(numberOfBribes));
        return;
    }

    //Helper Functions
    static void fillWithZeros(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=0;
        }
    }

    static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    static boolean checkSorted(int[] arr){
        for(int i=0; i< arr.length; i++){
            if(arr[i] != i+1)
                return false;
        }
        return true;
    }

    static int getSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
