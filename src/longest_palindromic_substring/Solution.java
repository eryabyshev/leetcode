package longest_palindromic_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static String longestPalindrome(String s) {
        Map<Character, List<Integer>> visited = new HashMap<>();
        String result = "";
        for (int end = 0; end <= s.length() - 1; end++) {
            char target = s.charAt(end);
            if(visited.containsKey(target)) {
                visited.get(target).add(end);
                for(Integer i : visited.get(target)) {
                    String temp = s.substring(i, end + 1);
                    if(temp.length() > result.length() && isPalindrome(temp)) {
                        result = temp;
                    }
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(end);
                visited.put(target, temp);
            }
        }
        return result.isEmpty() ? s.substring(0, 1) : result;
    }


    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end ) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("aacabdkacaa"));

    }
}
