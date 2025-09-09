package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Subarray_K_diff_int {
    public int subarraysWithKDistinct(int[] A, int K) {
        return counts(A,K) - counts(A,K-1);
    }

    public int counts(int[] A, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int count=0;

        if(k<=0){
            return 0;
        }
        while(j<A.length){
            map.put(A[j],map.getOrDefault(A[j],0)+1);
            while(map.size()>k){
                if(map.get(A[i]) == 1){
                    map.remove(A[i]);
                }
                else{
                    map.put(A[i],map.get(A[i])-1);
                }
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums  = {1,2,1,3,4};
        int k = 3;
        Subarray_K_diff_int obj = new Subarray_K_diff_int();
        System.out.println(obj.subarraysWithKDistinct(nums,k));
    }
}
