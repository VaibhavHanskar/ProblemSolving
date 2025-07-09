package BinarySearch;

public class SingleInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int i = 0;
        int j = nums.length -1;
        while(i<=j){
            int mid = i + (j-1)/2;

            if(i<mid && mid<j && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            if(mid%2 == 0){
                if(mid<j && nums[mid] == nums[mid+1]){
                    mid++;
                    i = mid+1;
                }
                else{
                    mid--;
                    j = mid-1;
                }
            }
            else{
                if(mid<j && nums[mid] == nums[mid+1]){
                    mid--;
                    j = mid-1;
                }
                else{
                    mid++;
                    i = mid+1;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,5};
        SingleInSortedArray obj = new SingleInSortedArray();
        int ans = obj.singleNonDuplicate(nums);
        System.out.println("Single Non Duplicate Element: " + ans);
    }
}
