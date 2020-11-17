package reverse_integer;

public class Solution {

    private static int reverse(int x) {
        if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }
        boolean minus = false;
        if(x < 0) {
            minus = true;
            x =Math.abs(x);
        }
        int result = 0;
        while (x != 0) {
            if(result > (Integer.MAX_VALUE / 10) + x % 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return minus ? result * -1 : result;
    }



    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

}
