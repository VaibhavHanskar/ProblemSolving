package Strings;
import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        StringBuilder ans  = new StringBuilder();

        char[] first = strs[0].toCharArray();
        char[] last  = strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i] != last[i]){
                break;
            }
            ans.append(first[i]);
        }
        return ans.toString();
    }

    public String longestPrefix(String[] strs){
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder ans = new StringBuilder(strs[0]);
        for(int i=1;i<strs.length;i++){
            char[] first = strs[i-1].toCharArray();
            char[] second = strs[i].toCharArray();
            int smallest = Math.min(first.length, second.length);
            StringBuilder temp  = new StringBuilder();
            for(int j=0;j<smallest;j++){
                if(first[j] != second[j]){
                    break;
                }
                temp.append(first[j]);
            }
            if(ans.length() > temp.length()){
                ans = temp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String ans = obj.longestPrefix(strs);
        System.out.println(ans);
    }
}
