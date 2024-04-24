package com.example.demo.sort;
import java.util.*;

public class BinaryArraySizeNotGiven {
    public static void main(String[] args) {
      int arr[]={1,2,4,5,6,7,8,9};
      int result=ans(arr,7);
      System.out.println(result);
  }
  static int ans(int[] nums, int target)
  {
    int start=0;
    int end=1;
    while(nums[end]<target){
      int temp=end+1;
      end=end+(end-start+1)*2;
      start=temp;
    }
    return binarySort(nums, target, start, end);
  }
  public static int binarySort(int[] nums, int target, int start, int end){
    while(start<=end){
      int mid=start+(end-start)/2;
      if(target<nums[mid]){
        end=mid-1;
      }
      else if(target>nums[mid]){
        start=mid+1;
      }
      else
        return mid;
    }
    return -1;
  }
}
