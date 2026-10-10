package Problems;

import java.util.HashSet;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 9;
        boolean isTwoSum = twoSum(nums,target);
        System.out.println(isTwoSum);
    }

    private static boolean twoSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for(int num : nums){
            int required = target - num;
            if(seen.contains(required)) return true;
            else seen.add(num);
        }
        return false;
    }
}
