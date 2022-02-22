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