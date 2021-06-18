package 初级算法;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class A001_removeDuplicates {

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] ints = new int[]{0, 0, 1};
//        int[] ints = new int[]{0, 1, 1};
        int newLen = removeDuplicates(ints);
        System.out.println("newLen: " + newLen);
        System.out.println(Arrays.toString(ints));
        Arrays.stream(ints).boxed()
                .map(String::valueOf)
                .reduce((a, b) -> a + ", " + b)
                .ifPresent(System.out::println);
    }

    /**
     * 直接使用快慢指针来解决
     * @param nums
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static int removeDuplicates_0(int[] nums) {
        int temp = Integer.MAX_VALUE;
        int minus = 0;
        // 先将所有多余的重复的元素设为-1
        for (int i = 0; i < nums.length; i++) {
            if (temp == nums[i]) {
                nums[i] = Integer.MAX_VALUE;
                minus++;
            } else {
                temp = nums[i];
            }
        }
        if (minus == 0) {
            return nums.length;
        }
        // 挪动元素
        int index = 0;
        for (int j = 0; index < nums.length - 1 && j < nums.length; ++index, j = Math.max(j, index)) {
//            System.out.println("index: " + index + ", j: " + j);
            if (nums[index] == Integer.MAX_VALUE) {
                while (j < nums.length && nums[j] == Integer.MAX_VALUE) {
                    j++;
                }
                if (j == nums.length)
                    break;
                nums[index] = nums[j];
                nums[j] = Integer.MAX_VALUE;
                j++;
            }
        }
        return nums.length - minus;
    }
}
