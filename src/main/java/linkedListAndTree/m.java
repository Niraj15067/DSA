package linkedListAndTree;

import java.util.Arrays;

public class m {

	public static void main(String[] args) {
		int[] arr = {9,3,2,5,7,1};
		mergeSort(arr, 0 , arr.length);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergeSort(int[] arr, int start, int end) {
		
		if(end-start==1) {
			return;
		}
		int mid = start+(end-start)/2;
		
		mergeSort(arr, 0, mid);
		mergeSort(arr, mid,end);
		
		merge(arr,start,mid,end);
	}
	public static void merge(int[] arr, int start, int mid, int end) {
		int s = start;
		int m = mid;
		int[] merged = new int[end-start];
		int i=0;
		while(s<mid && m<end) {
			if(arr[s]<arr[m]) {
				merged[i]=arr[s];
				s++;
			}else {
				merged[i]=arr[m];
				m++;
			}
			i++;
		}
		while(s<mid) {
			merged[i]=arr[s];
			s++;
			i++;
		}
		while(m<end) {
			merged[i]=arr[m];
			m++;
			i++;
		}
		System.arraycopy(merged, 0, arr, start, merged.length);
	}
}
