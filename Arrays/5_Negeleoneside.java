import java.util.*;

public class Negeleoneside{
    public static void rearrange(int[] arr, int n){
        int j = 0;
        for(int i = 0;i<n;i++){
            if(arr[i]<0){
                if(i!=j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    
                }
                j++;
            }
        }
    }
    public static void printArray(int[] arr, int n){
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr= {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr, n);
        printArray(arr, n);
    }
}

/*                Another Approach
Here, we will use the famous Dutch National Flag Algorithm for two “colors”. The first color will be for all negativeintegers and the second color will be for all positive integers. We will divide the array into three partitions with the helpof two pointers, low and high. 

    1. ar[1…low-1] negative integers

    2. ar[low…high] unknown

    3. ar[high+1…N] positive integers

Now, we explore the array with the help of low pointer, shrinking the unknows partition, and moving elements to their correct partition in the process. We do this until we have explored all the elements, and size of the unknown partition shrinks to zero.


public static void move(int[] ar){
    int low = 0;
    int high = ar.length - 1;
    while (low <= high) {
        if (ar[low] <= 0)
            low++;
        else
            swap(ar, low, high--);
    }
}



*/