// Split Array into two parts find Maxmium amongst them and then find minimum of all maximum value works with positive value
package Arrays;

public class SplitArrInTwoWithMinSumDiff {
    public int splitArray(int[] nums) {
        int ans = -1;
        if(nums.length ==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        int n = prefixSum.length-1;
        int minimum = Integer.MAX_VALUE;

        for(int i=0;i<prefixSum.length;i++){
            int v1 = prefixSum[i];
            int v2 = prefixSum[n]-prefixSum[i];

            int maxValue = Math.max(v1,v2);
            minimum = Math.min(minimum,maxValue);
        }

        return Math.max(ans,minimum);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        SplitArrInTwoWithMinSumDiff obj = new SplitArrInTwoWithMinSumDiff();
        int ans = obj.splitArray(nums);
        System.out.println(ans);

    }
}
