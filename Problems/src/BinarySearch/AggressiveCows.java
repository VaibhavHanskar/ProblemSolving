package BinarySearch;
import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        if(nums.length == 2 && k == 2){
            return nums[1]-nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int low = min;
        int high = max;
        int ans = high-low;
        while(low<=high){
            int mid  = low + (high-low)/2;
            boolean isPossible = possible(nums,mid,k,min);

            if(isPossible){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean possible(int[] nums, int distance, int cows, int low){
        int start = low;
        int placed = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] - start >= distance){
                start = nums[i];
                placed++;
            }
        }
        if(placed >= cows){
            return true;
        }
        return false;
    }

    public int cooows(int[] stalls, int k){
        Arrays.sort(stalls);
        if(stalls.length == 2 && k == 2){
            return stalls[1]-stalls[0];
        }


        int low = 1;
        int high = stalls[stalls.length-1];
        int ans = high-low;
        while(low<=high){
            int mid  = low + (high-low)/2;

            int start = stalls[0];
            int placed = 1;
            for(int i=0;i<stalls.length;i++){
                if(stalls[i] - start >= mid){
                    start = stalls[i];
                    placed++;
                }
            }
            if(placed >= k){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] stalls = {47,40};
        int cows = 2;
        int n = 5;
        AggressiveCows obj = new AggressiveCows();
        int ans = obj.cooows(stalls,cows);
        System.out.println(ans);
    }
}
