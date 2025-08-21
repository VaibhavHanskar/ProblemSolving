package BinarySearch;

import java.util.*;

public class PeakElement_II {
    public int findMaxValueIndex(int[][] mat, int col, int m){
        int maxValue = -1;
        int index = -1;
        for(int i=0;i<m;i++){
            if(mat[i][col] > maxValue){
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int m = mat.length;
        int n = mat[0].length;
        int l = 0;
        int r = n-1;
        while(l <= r) {
            int midCol = l + (r - l) / 2;
            int maxRowIndex = findMaxValueIndex(mat, midCol, m);
            int left = midCol-1>=0 ? mat[maxRowIndex][midCol-1] : -1;
            int right = midCol+1<n ? mat[maxRowIndex][midCol+1] : -1;
            int midValue = mat[maxRowIndex][midCol];
            if(midValue > left && midValue > right){
                ans[0] = maxRowIndex;
                ans[1] = midCol;
                return ans;
            }
            else if(midValue < right){
                l = midCol+1;
            }
            else{
                r = midCol-1;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4},
                {3,2}
        };
        PeakElement_II obj = new PeakElement_II();
        int[] ans = obj.findPeakGrid(matrix);
        System.out.println(Arrays.toString(ans));
    }
}
