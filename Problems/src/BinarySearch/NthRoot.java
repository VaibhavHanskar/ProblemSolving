package BinarySearch;

public class NthRoot {
    public int findNthRoot(int n, int m){
        if(n==1){
            return m;
        }

        int i = 1;
        int j = m;
        while(i<=j){
            int mid = i+(j-i)/2;
            int x = 1;
            for(int k=1;k<=n;k++){
                x *= mid;
                if(x>m){
                    break;
                }
            }

            if(x == m){
                return mid;
            }
            else if(x<m){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
            x=1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 2;
        int m = 121;
        NthRoot obj = new NthRoot();
        int ans = obj.findNthRoot(n,m);
        System.out.println(ans);
    }
}
