package com.example.demo.arrays;

import java.util.Arrays;

public class Sort012Array {

	public static void main(String[] args) {
		int[] arr = {0,1,2,0,1,2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/* Also known as Dutch National Flag problem.
	 * 1. Create 3 pointers named zero one and two.
	 * 2. Start zero and one from index 0 and two from index length -1.
	 * 3. If at index one we get value 0 then we swap zero and one indices. And do zero++ and one++.
	 * 4. If at index one we get value 1, we do nothing as the 1's are going to be in the mid just do index one++.
	 * 5. If at index two we get value 2, we swap indices one and two and do two--, not one++ as we might swap 2 at
	 * 	  index two with 2 at index one so need to check one again and then do one++ only when it's not 2.
	 */
	private static void sort(int[] arr) {
		int zero = 0, one = 0, two = arr.length-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[one]==1) {
				one++;
			}else if(arr[one]==0) {
				swap(arr,zero,one);
				zero++;
				one++;
			}else {
				swap(arr,one,two);
				two--;
			}
		}
		
	}

	private static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a]+arr[b];
		arr[b] = arr[a]-arr[b];
		arr[a] = arr[a]-arr[b];
	}
}
