//https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
package BinarySearch;

public class OccurenceOfTarget {

    public int countOccurance(int[] nums, int target){
        int count=0;
        if(nums.length == 1 && nums[0] == target){
            return 1;
        }
        if(nums[nums.length-1] < target){
            return count;
        }

        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;

            if(nums[mid] == target){
                 i = mid-1;
                 while(i>=0){
                     if(nums[i] != target){
                         break;
                     }
                     i--;
                 }
                 j = mid+1;
                 while(j<=nums.length-1){
                     if(nums[j] != target){
                         break;
                     }
                     j++;
                 }
                 count = j-i-1;
                 return count;
            }
            else if (nums[mid] < target) {
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        OccurenceOfTarget obj = new OccurenceOfTarget();
        System.out.println(obj.countOccurance(nums,target));
    }
}
