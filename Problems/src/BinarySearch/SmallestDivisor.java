// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
package BinarySearch;

public class SmallestDivisor {
    public int divisor(int[] nums, int threshold){
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int ans = max;
        int i =1;
        int j =max;
        while(i<=j){
            int mid = i + (j-i)/2;
            int sum = divide(nums,mid);
            if(sum <= threshold){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }

    public int divide(int[] nums, int divisor){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i]/divisor;
            if(nums[i] % divisor != 0){
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        SmallestDivisor obj = new SmallestDivisor();
        int ans = obj.divisor(nums,threshold);
        System.out.println(ans);
    }
}
