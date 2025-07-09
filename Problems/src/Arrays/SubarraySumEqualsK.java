package Arrays;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 1){
            if(nums[0] == k){
                return 1;
            }
            return 0;
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 3;
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int ans = obj.subarraySum(nums,k);
        System.out.println(ans);
    }
}
