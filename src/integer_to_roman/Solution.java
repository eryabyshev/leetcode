package integer_to_roman;

public class Solution {

    public static String intToRoman(int num) {

        StringBuilder result = new StringBuilder();

        while (num > 0) {

            if (num >= 1000) {
                result.append("M");
                num -= 1000;
                continue;
            }

            if (num >= 900) {
                result.append("CM");
                num -= 900;
                continue;
            }

            if (num >= 500) {
                result.append("D");
                num -= 500;
                continue;
            }

            if (num >= 400) {
                result.append("CD");
                num -= 400;
                continue;
            }

            if (num >= 100) {
                result.append("C");
                num -= 100;
                continue;
            }

            if (num >= 90) {
                result.append("XC");
                num -= 90;
                continue;
            }

            if (num >= 50) {
                result.append("L");
                num -= 50;
                continue;
            }

            if (num >= 40) {
                result.append("XL");
                num -= 40;
                continue;
            }

            if (num >= 10) {
                result.append("X");
                num -= 10;
                continue;
            }

            if (num >= 9) {
                result.append("IX");
                num -= 9;
                continue;
            }

            if (num >= 5) {
                result.append("V");
                num -= 5;
                continue;
            }

            if (num >= 4) {
                result.append("IV");
                num -= 4;
                continue;
            }
            //else
            result.append("I");
            num--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

}
