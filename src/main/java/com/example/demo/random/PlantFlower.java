package com.example.demo.random;

public class PlantFlower {

	public static void main(String[] args) {
		int[] arr= {1,0,0,0,1,0,0};
		boolean ans=canPlaceFlowers(arr, 1); 
		System.out.println(ans);
	}
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count=0;
        int plant=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                count++;
                if(i==flowerbed.length-2 && flowerbed[flowerbed.length-1]==0) {
                	count++;
                	plant++;
                }
                if(count==i+1)
                    plant=Math.max(plant, count/2);
                if(count%2==0)
                    plant=Math.max(plant, count/2-1);
                else
                    plant=Math.max(plant, count/2);
            }
            else
                count=0;
        }
        System.out.println(plant);
        if(plant>=n)
            return true;
        return false;
    }

}
