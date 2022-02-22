//scroll down for theory
import java.util.*;

public class MinMaxLeastComp{
    static class Pair{
        int min;
        int max;
    }
    public static Pair getMinMax(int[] arr, int l, int h){
        //array size is 1 then min and max will be arr[0]
        Pair ans = new Pair();
        if(l == h){
            ans.min = arr[l];
            ans.max = arr[h];
            return ans;
        }
        if(h == l + 1){
            if(arr[l]>arr[h]){
                ans.min = arr[h];
                ans.max = arr[l];
            }else{
                ans.min = arr[l];
                ans.max = arr[h];
            }
            return ans;
        }

        
        int mid = (l + h)/2;
        Pair mml = getMinMax(arr,l,mid);
        Pair mmr = getMinMax(arr, mid + 1, h);
        if(mml.min<mmr.min){
            ans.min = mml.min;
        }else{
            ans.min = mmr.min;
        }



        if(mmr.max>mml.max){
            ans.max = mmr.max;
        }else{
            ans.max = mml.max;
        }
        return ans;
    }




    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Pair ans = getMinMax(arr, 0, n-1);
        System.out.println("Min -> " + ans.min);
        System.out.println("Max -> " + ans.max);
    }
}
/*         Time Complexity
T(1) = 0 ....... for single element 0 comp is required.
T(2) = 1 ....... for 2 elements 1 comp is required.
T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2   ................ where n>2
T(n) = 2T(n/2) + 2   ...........  where n is a power of 2;

After solving
T(n) = 3n/2 - 2 ..... "No. of Comparisons"
*/


//////////////////////////////////////
/*                  Another Approach can be
    --> If n is odd then initialize min and max as first element. 
    --> If n is even then initialize min and max as minimum and maximum of the first two elements respectively. 
    --> For rest of the elements, pick them in pairs and compare their maximum and minimum with max and min respectively.

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;
        //If array has even number of elements then 
        //initialize the first two elements as minimum and maximum 
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
            //set the starting index for loop 
        } //If array has odd number of elements then 
    //initialize the first element as minimum and maximum 
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
            set the starting index for loop 
        }
 
        //In the while loop, pick elements in pair and 
     //compare the pair with max and min so far 
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
                //Increment the index by 2 as two 
               //elements are processed in loop 
        }
 
        return minmax;
    }


    If n is odd:    3*(n-1)/2  
    If n is even:   1 Initial comparison for initializing min and max, and 3(n-2)/2 comparisons for rest of the elements  =  1 + 3*(n-2)/2 = 3n/2 -2

*/