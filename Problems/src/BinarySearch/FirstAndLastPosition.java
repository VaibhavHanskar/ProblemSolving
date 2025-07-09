package BinarySearch;
import java.util.*;

public class FirstAndLastPosition {
    public int[] function(int[] nums, int target){
        int[] ans = {-1,-1};
        if(nums.length==1 && nums[0] == target){
            return new int[]{0,0};
        }
        int i =0;
        int j = nums.length-1;
        if(nums[i] == target && nums[j] == target){
            ans[i] = i;
            ans[j] = j;
            return new int[]{i,j};
        }

        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target){
                ans[1] = mid;
                int x = mid-1;
                while(x>=0 && nums[x] == nums[mid] ){
                    x--;
                }
                ans[0] = x+1;
                x = mid+1;
                while(x<=j && nums[x] == nums[mid]){
                    x++;
                }
                ans[1] = x-1;
                return ans;
            }
            else if(nums[mid] < target){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,2,2,3,4,5};
        FirstAndLastPosition obj = new FirstAndLastPosition();
        int[] ans = obj.function(nums,2);
        System.out.println(Arrays.toString(ans));
    }
}
