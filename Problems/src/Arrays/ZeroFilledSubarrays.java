package Arrays;

public class ZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return 1;
            }
            return 0;
        }
        long ans  = 0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j] != 0){
                i++;
                j++;
            }
            else{
                while(j<nums.length && nums[j]==0){
                    j++;
                }
                long diff = j - i;
                ans += diff * (diff+1)/2;
                i=j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,0,2,0,0};
        int[] nums = new int[100000];
        ZeroFilledSubarrays obj = new ZeroFilledSubarrays();
        System.out.println(obj.zeroFilledSubarray(nums));
    }
}
