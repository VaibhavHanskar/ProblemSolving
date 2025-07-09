package BinarySearch;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int j = arr.length-1;

        while(i<=j){
            int mid = i + (j-i)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return i+k;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        KthMissingPositiveNumber obj = new KthMissingPositiveNumber();
        int ans  = obj.findKthPositive(arr, k);
        System.out.println(ans);
    }
}
