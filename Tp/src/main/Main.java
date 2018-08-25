package main;

import java.util.Scanner;

public class Main {

	public static void quicksort(int []arr, int low, int high) {
		
		if(low < high) {
			int mid = low + (high - low)/2;
			int p = partition(arr, low, high);
			quicksort(arr, low, p - 1);
			quicksort(arr, p + 1, high);
		}
	}
	
	public static int partition(int []arr, int low, int high) {
		
		int p = arr[high];
		int i = -1;
		for(int j = low;j < high;j++) {
			
			if(arr[j] < p) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		i++;
		int temp = arr[high];
		arr[high] = arr[i];
		arr[i] = temp;
		
		return i;	
	}
	
	public static int getMax(int []men, int []women) {
		
		if(men.length == 0 || women.length == 0)
			return -1;
		
		quicksort(men, 0, men.length - 1);
		quicksort(women, 0, women.length - 1);
		
		int i = men.length -1, j = women.length -1, sum = 0;
		while(i >= 0 && j >= 0) {
		
			sum += men[i] * women[i];
			i--;j--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []men, women;
		for(int i = 0;i < N;i++) {
			
			int size = sc.nextInt();
			men = new int [size];
			women = new int[size];
			
			for(int j = 0;j < size;j++)
				men[j] = sc.nextInt();
			
			for(int j = 0;j < size;j++)
				women[j] = sc.nextInt();
			
			System.out.println(getMax(men, women));
		}*/
		int []arr = {2, 3 , 2};
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
		quicksort(arr, 0, 2);
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
