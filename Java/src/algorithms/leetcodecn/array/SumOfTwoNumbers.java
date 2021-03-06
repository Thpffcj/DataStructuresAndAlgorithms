package algorithms.leetcodecn.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thpffcj on 2019/10/8.
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwoNumbers {

    public int[] twoSum(int[] nums, int target) {

        int[] current = Arrays.copyOf(nums, nums.length);
        Arrays.sort(current);

        int[] result = new int[2];
        int start = 0;
        int end = current.length - 1;
        while (start < end) {
            int sum = current[start] + current[end];
            if (sum == target) {
                result[0] = findDigit(nums, current[start]);
                result[1] = findDigit(nums, current[end]);
                return result;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    private int findDigit(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                nums[i] = Integer.MIN_VALUE;
                return i;
            }
        }
        return -1;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
