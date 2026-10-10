package Problems;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0,1,3};
        long missionNumber = missingNumber(arr);
        System.out.println(missionNumber);

    }

    private static long missingNumber(int[] arr) {
        int n= arr.length;
        long expectedSum = (long) n * (n+1)/2;
        long actualSum=0;
        for(int a: arr){
            actualSum += a;
        }
        return  (expectedSum - actualSum);
    }
}
