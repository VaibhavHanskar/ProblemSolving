package Strings;

public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        long ans=0;
        boolean negative = false;
        char[] charArr = s.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i] =='-' && i==0){
                negative = true;
            }
            else if(charArr[i]-'0' <= 9){
                if(charArr[i] == '+' && i==0 ){
                    continue;
                }
                int j=i;
                while(j<charArr.length && charArr[j]-'0' <= 9 && charArr[j]-'0'>=0){
                    ans *= 10;
                    ans += charArr[j]-'0';
                    if(ans > Integer.MAX_VALUE || ans<Integer.MIN_VALUE){
                        if(negative){
                            ans  = Integer.MAX_VALUE+1;
                        }
                        else{
                            ans  = Integer.MAX_VALUE;
                        }
                        break;
                    }
                    j++;
                }
                break;
            }
            else{
                return 0;
            }
        }

        if(negative){
            return (int)-ans;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        String s = "18446744073709551617";
        StringToInteger obj = new StringToInteger();
        System.out.println(obj.myAtoi(s));
    }
}
