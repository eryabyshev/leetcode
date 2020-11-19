package palindrome_number;

public class Solution {


    private static boolean isPalindrome(int x) {
        if(x < 0) return false;

        int copy = x;
        int result = 0;

        while (x > 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x /= 10;
        }
        return result == copy;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(-11));
    }
}
