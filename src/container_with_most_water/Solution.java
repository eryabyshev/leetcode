package container_with_most_water;

public class Solution {

    private static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;

        while (end > start) {
            int tempMinHeight = Math.min(height[start], height[end]);
            int temp = tempMinHeight * (end - start);
            if(temp > result) {
                result = temp;
            }
            if(tempMinHeight == height[start]) {
                start++;
            } else {
                end --;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1}));
    }
}
