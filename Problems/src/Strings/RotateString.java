package Strings;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        int n = s.length();
        char[] sChar = s.toCharArray();
        char[] goalChar =goal.toCharArray();
        int index = -1;
        while(i<n && j<n){
            if(sChar[i] != goalChar[j]){
                j++;
            }
            else{
                index = j;
                while(i<n-index && j<n){
                    if(sChar[i] != goalChar[j]){
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }

        j = 0;
        while(j<index && i<n){
            if(sChar[i] != goalChar[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public boolean rs(String s, String goal){
        if (s.length() != goal.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] goalChar = goal.toCharArray();
        int n = s.length();
        int i = n-1;
        int j = n-1;
        int index = -1;
        while(i>-1 && j>-1){
            if(sChar[i] != goalChar[j]){
                j--;
            }
            else{
                index = j;
                while(i>-1 && j>-1){
                    if (i<n && sChar[i] != goalChar[j] ) {
                        i++;
                        index = j;
                        continue;
                    }
                    i--;
                    j--;
                }
            }
        }
        j = n-1;
        while(i>-1 && j>index){
            if (sChar[i] != goalChar[j]) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        RotateString obj  = new RotateString();
        System.out.println(obj.rs(s,goal));
    }
}
