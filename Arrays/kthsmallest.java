import java.util.*;

public class Main
{
    class MinHeap{
        int[] harr;
        int cap;
        int size;
        
        int parent(int i){
            return (i-1)/2;
        }
        int right(int i){
            return 2 * i + 2;
        }
        int left(int i){
            return 2 * i + 1;
        }
        int getMin(){
            return harr[0];
        }
        void replaceMax(int i){
            this.harr[0] = i;
            minHeapify(0);
        }
        MinHeap(int[] arr, int size){
            this.size = size;
            harr = arr;
            int i = (this.size - 1)/2;
            while(i>=0){
                minHeapify(i);
                i--;
            }
        }
        int removeMin(){
            if(this.size == 0){
                return Integer.MAX_VALUE;
            }
            int root = harr[0];
            
            
            if(this.size>1){
               harr[0] = harr[this.size - 1];
               size--;
               minHeapify(0);
            }
            return root;
        }
        void minHeapify(int x){
            int l = left(x);
            int r = right(x);
            int smallest = x;
            int tmp;
            
            if(l<this.size && harr[l] < harr[smallest]){
                smallest = l;
            }
            if(r<this.size && harr[r] < harr[smallest]){
                smallest = r;
            }
            if(smallest != x){
                tmp = harr[x];
                harr[x] = harr[smallest];
                harr[smallest] = tmp;
                minHeapify(smallest);
            }
        }
    }
    public  int getKthSmallest(int[] arr,int n ,int k){
        MinHeap hp = new MinHeap(arr, n);
        for(int i = 0;i<k-1;i++){
            hp.removeMin();
        }
        return hp.getMin();
    }
    
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
		    arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		Main hello = new Main();
		System.out.println(hello.getKthSmallest(arr,n,k));
		
		
	}
}
