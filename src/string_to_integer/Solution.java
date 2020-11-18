package string_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        int v = 0;
        for(char k = '0'; k <= '9' ; k++, v++) {
            map.put(k, v);
        }
    }


    private static int myAtoi(String s) {

        int result = 0;
        boolean number = false;
        boolean letter = false;
        boolean minus = false;
        boolean plus = false;
        boolean space = false;

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && !letter) {
                number = true;
                int temp = map.get(s.charAt(i));

                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)) {
                    return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + temp;

            } else {
                if(s.charAt(i) == ' ') {
                    if(number) {
                        return minus ? result * -1 : result;
                    }
                    if(plus || minus) {
                        return 0;
                    }
                    continue;
                }
                else if(s.charAt(i) == '-' && !number && !plus) {
                    if(minus) {
                        return 0;
                    }
                    minus = true;
                }
                else if (s.charAt(i) == '+' && !number && !minus) {
                    if(plus) {
                        return 0;
                    }
                    plus = true;
                }

                else {
                    letter = true;
                }
                if(number && result == 0) {
                    return 0;
                }
            }
        }
        return minus ? result * -1 : result;
    }


    public static void main(String[] args) {

        System.out.println(myAtoi("++1"));

    }


}
