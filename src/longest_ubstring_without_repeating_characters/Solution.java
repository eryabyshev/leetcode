package longest_ubstring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> visited = new HashMap<>();
        int result = 0;
        for (int start = 0, end = 0; end <= s.length() - 1; end++) {
            char target = s.charAt(end);
            if(visited.containsKey(target)) {
                start = Math.max(visited.get(target) + 1, start);
            }

            result = Math.max(result, end - start + 1);

            visited.put(target, end);
        }
        return result;
    }




    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abc"));

    }

}
