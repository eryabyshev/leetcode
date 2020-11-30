package letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {

    static Map<Character, List<Character>> BUTTON_TO_LETTER = new HashMap<>();

    static {
        BUTTON_TO_LETTER.put('2', Arrays.asList('a', 'b', 'c'));
        BUTTON_TO_LETTER.put('3', Arrays.asList('d', 'e', 'f'));
        BUTTON_TO_LETTER.put('4', Arrays.asList('g', 'h', 'i'));
        BUTTON_TO_LETTER.put('5', Arrays.asList('j', 'k', 'l'));
        BUTTON_TO_LETTER.put('6', Arrays.asList('m', 'n', 'o'));
        BUTTON_TO_LETTER.put('7', Arrays.asList('p', 'q', 'r', 's'));
        BUTTON_TO_LETTER.put('8', Arrays.asList('t', 'u', 'v'));
        BUTTON_TO_LETTER.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return Collections.emptyList();
        }
        Queue<String> combination = new ArrayDeque<>(combination("", BUTTON_TO_LETTER.get(digits.charAt(0))));

        for(int i = 1; i < digits.length(); i++) {
            int oldSize = combination.size();
            for(int j = 0; j < oldSize; j++) {
                combination.addAll(combination(combination.poll(), BUTTON_TO_LETTER.get(digits.charAt(i))));
            }
        }
        return new ArrayList<>(combination);
    }


    private static List<String> combination(String start, List<Character> button) {
        List<String> result = new ArrayList<>();
        for (Character c : button) {
            result.add(start + c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((letterCombinations("234")));
    }

}
