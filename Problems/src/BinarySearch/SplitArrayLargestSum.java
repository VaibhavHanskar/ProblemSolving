package BinarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSum += nums[i];
        }
        if(k==1){
            return maxSum;
        }
        if(nums.length < k){
            return -1;
        }

        int low = nums[0];
        for(int i=1;i<nums.length;i++){
            low = Math.max(nums[i],low);
        }
        int ans = maxSum;
        while(low <= maxSum){
            int mid = low + (maxSum-low)/2;
            int splits = splitPage(nums,mid);
            if(splits == k){
                ans = Math.min(ans,mid);
                maxSum = mid-1;
                continue;
            }
            if(splits < k){
                maxSum = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int splitPage(int[] nums, int range){
        int split = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+ sum <=  range){
                sum += nums[i];
            }
            else{
                split++;
                sum = nums[i];
            }
        }
        return split;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int k = 5;
        SplitArrayLargestSum obj = new SplitArrayLargestSum();
        int ans = obj.splitArray(nums,k);
        System.out.println(ans);
    }
}
