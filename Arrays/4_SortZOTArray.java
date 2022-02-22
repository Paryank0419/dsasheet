// Java program to sort an array of 0, 1 and 2
import java.io.*;

class SortZOTArray {

	static void sort012(int a[], int arr_size)
	{
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a[mid]) {
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	/* Utility function to print array arr[] */
	static void printArray(int arr[], int arr_size)
	{
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	
	public static void main(String[] args)
	{
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		System.out.println("Array before seggregation ");
		printArray(arr, arr_size);

		sort012(arr, arr_size);

		System.out.println("Array after seggregation ");
		printArray(arr, arr_size);
	}
}



/*
The problem was posed with three colours, here `0', `1' and `2'. The array is divided into four sections:

	-->a[1..Lo-1] zeroes (red)
	-->a[Lo..Mid-] ones (white)
	-->a[Mid..Hi] unknown
	-->a[Hi+1..N] twos (blue)


The unknown region is shrunk while maintaining these conditions.

Algorithm:
	Begin:

	Lo := 1; Mid := 1; Hi := N;
	while Mid <= Hi do
		Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
		case a[Mid] in
			0: swap a[Lo] and a[Mid]; Lo++; Mid++ //We only increment area related variable when we confirm the presence of
			1: Mid++                               // correct element like when we get a[mid] == 0 then we increase Lo++
			2: swap a[Mid] and a[Hi]; Hi--
	End


--- Dutch National Flag Algorithm, or 3-way Partitioning ---


*/