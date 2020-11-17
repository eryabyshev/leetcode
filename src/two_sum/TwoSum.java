package two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueToPos.containsKey(target - nums[i]) && valueToPos.get(target - nums[i]) != i) {
                return new int[] {valueToPos.get(target - nums[i]), i};
            }

            valueToPos.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }


    public static void main(String[] args) {


        int[] ints = twoSum(new int[]{3, 3}, 6);

        System.out.println(ints[0] + " " + ints[1]);
    }
}
