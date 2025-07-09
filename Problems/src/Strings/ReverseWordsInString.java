//https://leetcode.com/problems/reverse-words-in-a-string/description/
package Strings;

public class ReverseWordsInString {
    public String reverseWords(String s) {
       s  = removeSpaces(s);
       char[] charArr = s.toCharArray();
       reverseString(charArr,0,s.length()-1);
       reverseWords(charArr);
       return new String(charArr);
    }

    public String removeSpaces(String s){
        StringBuilder newSting = new StringBuilder();
        s.trim();
        int i=0;
        int j=s.length();
        while(i<j){
            if(s.charAt(i) == ' '){
                while(i<j & s.charAt(i)==' '){
                    i++;
                }
                int x = i-1;
                newSting.append(s.charAt(x));
            }
            else{
                newSting.append(s.charAt(i));
                i++;
            }
        }
        return newSting.toString();
    }

    public void reverseString(char[] arr, int i, int j){
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseWords(char[] arr){
        int i =0;
        int j =0;
        while(i<arr.length){
            if(j<arr.length && j!= ' '){
                j++;
            }
            else{
                reverseString(arr,i,j-1);
                j++;
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWordsInString obj = new ReverseWordsInString();
        String ans = obj.reverseWords(s);
        System.out.println(ans);
    }
}
