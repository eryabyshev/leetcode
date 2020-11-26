package longest_common_prefix;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; ; i ++) {
            Set<Character> temp = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                temp.add(getChar(strs[j], i));
            }
            if(temp.size() == 1 && temp.contains(' ')) {
                return strs[0];
            }

            if(temp.size() != 1) {
                return strs[0].substring(0, i);
            }
        }

    }

    private static Character getChar(String s, int pos) {
        if(pos > s.length() - 1) return ' ';
        return s.charAt(pos);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flower","flower","flower"}));
    }
}
