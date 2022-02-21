import java.util.*;

class Reversearray{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        for(int i = 0, j = arr.length - 1;i<j;){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}