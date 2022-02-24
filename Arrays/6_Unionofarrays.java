import java.util.*;

public class Unionofarrays{
    public static int[] doUnion(int[] a, int n, int[] b, int m){
        int total = n + m;
        int[] newArray = new int[total];
        for(int i = 0;i<n;i++){
            newArray[i] = a[i];
        }
        int temp = n;
        for(int i = 0;i<m;i++){
            newArray[temp] =  b[i];
            temp++;
        }
        Arrays.sort(newArray);
        //removing duplicates
        int j = 0;
        for(int i = 0;i<total-1;i++){
            if(newArray[i] != newArray[i+1]){
                newArray[j++] = newArray[i];
            }
        }
        newArray[j++] = newArray[total-1];
        int[] arr = new int[j];
        for(int i = 0;i<j;i++){
            arr[i] = newArray[i];
        }
        return arr;

    }

    public static void main{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0;i<n;i++){
            a[i] = scn.nextInt();

        }
        for(int i = 0;i<m;i++){
            b[i] = scn.nextInt();
        }
        int[] ans = doUnion(a, n, b, m);
        for(int i = 0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }
}

/*                     Theory 



*/