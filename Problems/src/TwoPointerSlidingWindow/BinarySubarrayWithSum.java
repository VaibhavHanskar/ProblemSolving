package TwoPointerSlidingWindow;

public class BinarySubarrayWithSum {


    public int subarraySumPrefixSum(int[] nums, int goal){
        int ans =0;
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] maxSum = new int[nums.length];
        leftSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            leftSum[i] = leftSum[i-1] + nums[i];
        }
        rightSum[nums.length - 1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rightSum[i] = rightSum[i+1] + nums[i];
        }

        for(int i=0;i<nums.length;i++){
            maxSum[i] = Math.max(leftSum[i],rightSum[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(maxSum[i] - nums[i] == goal){
                ans++;
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int goal){
        int ans = 0;
        if(nums.length == 1){
            if(nums[0] == goal){
                return nums[0];
            }
            else{
                return 0;
            }
        }


        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums,goal) - f(nums,goal-1);
    }

    public int f(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int sum = 0;
        int count = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal  = 2;
        BinarySubarrayWithSum obj = new BinarySubarrayWithSum();
        System.out.println(obj.numSubarraysWithSum(nums,goal));
    }
}
