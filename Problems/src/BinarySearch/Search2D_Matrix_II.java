package BinarySearch;

public class Search2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length-1;
        for(int i=0;i<m;i++){
            if(matrix[i][n] < target){
                continue;
            }
            int l = 0;
            int r = n;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(matrix[i][mid] == target){
                    return true;
                }
                else if(matrix[i][mid] < target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        Search2D_Matrix_II obj = new Search2D_Matrix_II();
        System.out.println(obj.searchMatrix(matrix,target));
    }
}
