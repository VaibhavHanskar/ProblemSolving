package Arrays;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>0  && nums[i]!= nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            int rem = target - (nums[i]+nums[j]+nums[k]);
            if(set.contains(-rem)){
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                ans.add(new ArrayList<>(Arrays.asList(b,c,rem)));
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]) j++;
                while(j<k && nums[k]==nums[k+1]) k--;
            }
            else if(rem < target){
                j++;
            }
            else{
                k--;
            }
            set.add(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target  = 0;
        FourSum obj = new FourSum();
        System.out.println(obj.fourSum(nums,target));
    }
}
