//https://takeuforward.org/plus/dsa/problems/book-allocation-problem
package Arrays;

public class BookAllocation {
    public int findPages(int[] nums, int m) {
        if(m > nums.length){
            return -1;
        }

        int maxSum=nums[0];
        for(int i=0;i<nums.length;i++){
            maxSum += nums[i];
        }

        if(m == 1){
            return maxSum;
        }

        int low = nums[0];
        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
        }

        for(int pages=low;pages<=maxSum;pages++){
            int student = splits(nums,pages);
            if(student == m){
                return pages;
            }
        }

        return -1;
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
        int[] nums = {25, 46, 28, 49, 24};
        int m = 4;
        BookAllocation obj = new BookAllocation();
        int ans = obj.findPages(nums,m);
        System.out.println(ans);
    }
}
