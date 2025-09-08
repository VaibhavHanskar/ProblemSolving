package Arrays;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int product = 1;
        int max = 0;
        int j = 0;
        int i = 0;
        while(i<nums.length){
            product *= nums[i];
            if(product > 0){
                max = Math.max(product,max);
            }
            else{
                product /= nums[j];
                j++;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1,4};
        MaxProductSubarray obj = new MaxProductSubarray();
        System.out.println(obj.maxProduct(nums));
    }
}
