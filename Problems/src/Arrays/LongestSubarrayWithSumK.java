//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public int longestSubarraySum(int[] arr, int k) {
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum == k){
                    int len = j-i+1;
                    ans = Math.max(len,ans);
                }
            }
        }
        return ans;
    }

    public int longestSubarray(int[] arr, int k){
        int ans=0;
        int prefix = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            prefix += arr[i];
            int sum = prefix - k;
            if(map.containsKey(sum)){
                int len = map.get(sum) - i + 1;
                ans  = Math.max(ans,len);
            }
            map.put(arr[i],i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        LongestSubarrayWithSumK obj = new LongestSubarrayWithSumK();
        int ans = obj.longestSubarray(arr,k);
        System.out.println(ans);
    }
}
