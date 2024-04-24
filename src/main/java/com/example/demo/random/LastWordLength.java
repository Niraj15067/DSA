package com.example.demo.random;

public class LastWordLength {

	public static void main(String[] args) {
		int ans=abc("   fly me   to   the moon  ");
		System.out.println(ans);
	}

	private static int abc(String s) {
		String filter=s.trim();
		int len = filter.length()-1;
        int count=0;

        while(len>=0){
            if(filter.charAt(len)==' ')
                break;
            count++;
            len--;
        }
        return count;
	}

}
