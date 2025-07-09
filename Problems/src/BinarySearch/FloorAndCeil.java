package BinarySearch;

public class FloorAndCeil {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = {-1,-1};
        if(nums.length ==1){
            if(nums[0] == x){
                ans[0] = nums[0];
                ans[1] = nums[0];
            }
            else if(nums[0] < x){
                ans[0] = nums[0];
            }
            else if(nums[0] > x){
                ans[1] = nums[0];
            }
            else{
                return ans;
            }
        }

        int i = 0;
        int j = nums.length - 1;

        while(i<=j){
            int mid = i + (j-i)/2;

            if(nums[mid] == x){
                ans[0] = nums[mid];
                j=mid-1;
                continue;
            }

            if(nums[mid] < x){
                ans[0] = nums[mid];
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }

        i = 0;
        j = nums.length - 1;

        while(i<=j){
            int mid = i+(j-i)/2;

            if(nums[mid] > x){
                ans[1] = nums[mid];
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
        int nums[] ={3, 4, 4, 7, 8, 10};
        int x = 5;
        FloorAndCeil obj = new FloorAndCeil();
        int[] ans = obj.getFloorAndCeil(nums, x);
        System.out.println("Floor: " + ans[0] + ", Ceil: " + ans[1]);
    }
}
