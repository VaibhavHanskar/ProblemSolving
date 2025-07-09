package Arrays;

import java.util.Arrays;

// P-189 Leetcode
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k %= size;
        reverse(nums,0,size-1-k);
        reverse(nums,size-k,size-1);
        reverse(nums,0,size-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        RotateArray obj = new RotateArray();
        System.out.println("Before Rotation: " + Arrays.toString(nums));
        obj.rotate(nums,k);
        System.out.println("\nAfter Rotation: "+ Arrays.toString(nums));
    }
}
