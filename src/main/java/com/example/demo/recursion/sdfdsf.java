package com.example.demo.recursion;

public class sdfdsf {

    public static void main(String[] args) {
        String input = "abc";
        generatePermutations("", input);
    }

    private static void generatePermutations(String processed, String remaining) {
        // Base case: If there are no characters remaining, print the permutation
        if (remaining.isEmpty()) {
            System.out.println(processed);
            return;
        }

        // Recursive case: Iterate through each character in the remaining string
        for (int i = 0; i < remaining.length(); i++) {
            // Take out the current character
            char currentChar = remaining.charAt(i);

            // Build the new processed string with the current character
            String newProcessed = processed + currentChar;

            // Build the new remaining string without the current character
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            // Recursively call the function with the new processed and remaining strings
            generatePermutations(newProcessed, newRemaining);
        }
    }
}
