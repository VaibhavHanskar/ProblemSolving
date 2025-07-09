package BinarySearch;

//https://takeuforward.org/plus/dsa/problems/lower-bound-
public class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int ans = -1;
        int i = 0;
        int j = nums.length - 1;

        while(i<=j){
            int mid = i + (j-i)/2;

            if(nums[mid] == x){
                ans = mid;
                j=mid-1;
                continue;
            }

            if(nums[mid] > x){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3};
        int x = 2;
        LowerBound obj = new LowerBound();
        int ans = obj.lowerBound(nums, x);
        System.out.println("Lower Bound of " + x + " is: " + ans);
    }
}
