package roman_to_iInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static Map<Character, Integer> ROMA_TO_INT = new HashMap<>();

    static {
        ROMA_TO_INT.put('I', 1);
        ROMA_TO_INT.put('V', 5);
        ROMA_TO_INT.put('X', 10);
        ROMA_TO_INT.put('L', 50);
        ROMA_TO_INT.put('C', 100);
        ROMA_TO_INT.put('D', 500);
        ROMA_TO_INT.put('M', 1000);
    }

    private static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += ROMA_TO_INT.get(s.charAt(i)) * getSign(s, i, i + 1);
        }
        return result;
    }

    private static int getSign(String s, int pos1, int pos2) {
        if(pos2 >= s.length()) return 1;
        if(ROMA_TO_INT.get(s.charAt(pos1)) >= ROMA_TO_INT.get(s.charAt(pos2))) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.print(romanToInt("DCXXI"));
    }

}
