package BinarySearch;

public class SqRoot {
    public int root(int num){
        int ans = 1;
        int i = 1;
        int j = num;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(mid*mid == num){
                ans = mid;
                return ans;
            }
            else if(mid*mid < num){
                ans = mid;
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 1;
        SqRoot obj = new SqRoot();
        System.out.println(obj.root(num));
    }
}
