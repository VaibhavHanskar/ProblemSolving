package Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums.length == 2){
            if(nums[0] > 2*nums[1]){
                return 1;
            }
            return 0;
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){

                if(nums[i]/2 > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        ReversePairs obj = new ReversePairs();
        System.out.println(obj.reversePairs(nums));
    }
}
