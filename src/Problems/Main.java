package Problems;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int largest = nums[0],secondLargest=Integer.MIN_VALUE;
        for(int num : nums){
            if(num > largest){
                secondLargest=largest;
                largest=num;
            }else if (num < largest && num > secondLargest){
                secondLargest = num;
            }
        }

        System.out.println("Second largest Number :" + secondLargest);
    }
}
