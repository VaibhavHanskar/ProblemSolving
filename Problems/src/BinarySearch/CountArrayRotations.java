//https://takeuforward.org/plus/dsa/problems/find-out-how-many-times-the-array-is-rotated
package BinarySearch;

public class CountArrayRotations {
    public int findKRotation(int[] nums) {
        int index = 0;
        int smallest = Integer.MAX_VALUE;
        if(nums.length == 0 || nums[0] < nums[nums.length-1]){
            return index;
        }

        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(nums[i] <= nums[mid]){
                if(nums[i] < smallest){
                    smallest = nums[i];
                    index = i;
                }
                i = mid+1;
            }
            else{
                if(nums[mid] < smallest){
                    smallest = nums[mid];
                    index = mid;
                }
                j = mid-1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        CountArrayRotations obj = new CountArrayRotations();
        int ans = obj.findKRotation(nums);
        System.out.println(ans);
    }
}
