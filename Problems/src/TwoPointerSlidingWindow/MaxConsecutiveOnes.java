package TwoPointerSlidingWindow;

public class MaxConsecutiveOnes {
    public int longestOnesM1(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int ans = 0;
        int i = 0;
        int j = 1;
        int extra = k;
        if(prefix[0] == 0){
            prefix[0] = 1;
            extra--;
        }
        while(j<nums.length){
            if(nums[j] == 0){
                if(extra > 0){
                    prefix[j] = 1 + prefix[j-1];
                    extra--;
                    if(j == nums.length-1){
                        ans = Math.max(ans,prefix[j]);
                    }
                }
                else{
                    ans = Math.max(ans,prefix[j-1]);
                    if(nums[i] == 0 && extra < k){
                        extra++;
                        prefix[j] = prefix[j-1] - 1;
                        i++;
                    }
                    else {
                        i = j;
                        prefix[j] = 1;
                    }

                }
            }
            else{
                prefix[j] = nums[j] + prefix[j-1];
                if(j==nums.length-1){
                    ans = Math.max(ans,prefix[j]);
                }
            }
            j++;
        }
        return ans;
    }

    public int longestOnesM2(int[] nums, int k){
        if(nums.length == 1){
            if(k==0){
                return nums[0];
            }
            else{
                return 1;
            }
        }
        int i=0;
        int j=0;
        int extra = k;
        int ans = 0;
        while(j<nums.length){
            if(nums[j] == 0){
                if(extra == 0){
                    int len = j-i;
                    ans = Math.max(ans,len);
                    if(nums[i] == 0 && extra<k){
                        extra++;
                    }
                    if(i == j){
                        j++;
                    }
                    i++;
                }
                else{
                    extra--;
                    j++;
                }
            }
            else{
                j++;
            }
        }
        ans = Math.max(ans,j-i);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1};
        int k = 4;
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int ans = obj.longestOnesM2(nums,k);
        System.out.println(ans);
    }
}
