package BinarySearch;

public class UpperBound {
    public int upperBound(int[] nums, int x) {
        int ans = nums.length;
        if(ans == 1){
            if(nums[0] > x){
                return 0;
            }
            else{
                return 1;
            }
        }

        int i = 0;
        int j = nums.length-1;

        while(i<=j){
            int mid = i+(j-i)/2;

            if(nums[mid] > x){
                ans = mid;
            }

            if(nums[mid] <= x){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,8,15,19};
        int x = 9;
        UpperBound obj = new UpperBound();
        int ans = obj.upperBound(nums, x);
        System.out.println("Upper Bound of " + x + " is: " + ans);
    }
}
