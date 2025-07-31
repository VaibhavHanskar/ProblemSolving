package TwoPointerSlidingWindow;
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/


public class SubstringContainingAllCharacters {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] charArr = new int[3];
        int left  = 0;
        int right = 0;
        while(right < s.length()){


        }
        return ans;
    }
    public static void main(String[] args) {
        SubstringContainingAllCharacters obj = new SubstringContainingAllCharacters();
        String s  = "abcabc";
        System.out.println(obj.numberOfSubstrings(s));
    }
}
