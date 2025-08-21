package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> outer = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int si = intervals[i][0];
            int ei = intervals[i][1];
            if(si <= end){
                start = Math.min(si,start);
                end = Math.max(ei,end);
            }
            else{
                List<Integer> inner = new ArrayList<>(Arrays.asList(start,end));
                outer.add(inner);
                start = si;
                end  = ei;
            }
        }

        outer.add(Arrays.asList(start,end));

        int[][] ans = new int[outer.size()][2];
        for(int i=0;i<ans.length;i++){
            List<Integer> x = outer.get(i);
            ans[i][0] = x.get(0);
            ans[i][1] = x.get(1);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,4,},{4,5}};
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        int[][] ans = obj.merge(intervals);
        for(int[] arr : ans){
            System.out.println(Arrays.toString(arr));
        }
    }
}
