package com.example.demo.string;

import java.util.HashMap;

import javax.net.ssl.SSLContext;

public class Isomorphic {

	public static void main(String[] args) {
		boolean ans = isIsomorphic("egg", "add");
		System.out.println(ans);
	}

	public static  boolean isIsomorphic(String s, String t) {
	
		HashMap<Character, Character> sm = new HashMap<>();
		HashMap<Character, Character> tm = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if(sm.containsKey(sc)) {
				if(!(sm.get(sc)==tc)) {
					return false;
				}
			}else {
				sm.put(sc, tc);
			}
			if(tm.containsKey(tc)) {
				if(!(tm.get(tc)==sc)) {
					return false;
				}
			}else {
				tm.put(tc, sc);
			}
			
		}
		return true;
	}
}
