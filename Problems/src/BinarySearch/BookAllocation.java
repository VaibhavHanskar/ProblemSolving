//https://takeuforward.org/plus/dsa/problems/book-allocation-problem
package BinarySearch;

public class BookAllocation {
    public int findPages(int[] nums, int m) {
        if(m > nums.length){
            return -1;
        }

        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            maxSum += nums[i];
        }

        if(m == 1){
            return maxSum;
        }

        int low = nums[0];
        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
        }
        int ans = maxSum;
        while(low <= maxSum){
            int mid = low + (maxSum - low)/2;
            int students = splits(nums,mid);
            if(students == m){
                ans = Math.min(ans,mid);
                maxSum = mid-1;
                continue;
            }
            if(students < m){
                maxSum = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int splits(int[] nums, int pages){
        int student =1;
        int pageDistribution = 0;
        for(int i=0;i<nums.length;i++){
            if(pageDistribution + nums[i] <= pages){
                pageDistribution += nums[i];
            }
            else{
                student++;
                pageDistribution = nums[i];
            }
        }
        return student;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        BookAllocation obj = new BookAllocation();
        int ans = obj.findPages(nums,m);
        System.out.println(ans);
    }
}
