package Arrays;

import java.util.*;

public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+n-1;j++){
                int index = j%n;
                if(nums[index] > nums[i]){
                    ans[i] = nums[index];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums  = {1,2,3,4,3};
        NextGreaterElement_II obj = new NextGreaterElement_II();
        System.out.println(Arrays.toString(obj.nextGreaterElements(nums)));
    }
}
//This has an Optimisied Version
