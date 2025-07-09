//https://leetcode.com/problems/largest-odd-number-in-string/description/
package Strings;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        if(num.length() == 1){
            long n = Long.parseLong(num);
            if(n%2 != 0){
                return num;
            }
            return "";
        }

        char[] charArr = num.toCharArray();
        int len = charArr.length - 1;
        for(int i=len;i>=0;i--){
            int value = charArr[i] - '0';
            if(value%2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "239537672423884969653287101";
        LargestOddNumber obj = new LargestOddNumber();
        String ans = obj.largestOddNumber(num);
        System.out.println(ans);
    }
}
