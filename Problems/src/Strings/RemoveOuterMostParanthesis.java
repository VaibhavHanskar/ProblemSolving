//https://leetcode.com/problems/remove-outermost-parentheses/description/
package Strings;

import java.util.Stack;

public class RemoveOuterMostParanthesis {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder("");

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                if(stack.size()!=0){
                    ans.append(s.charAt(i));
                }
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                stack.pop();
                if(stack.size()!=0){
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }

    public String parenthesis(String s){
        int counter = 0;
        StringBuilder ans = new StringBuilder();

        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                counter--;
            }
            if(counter != 0){
                ans.append(s.charAt(i));
            }
             if(s.charAt(i) == '('){
                 counter++;
             }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        RemoveOuterMostParanthesis obj = new RemoveOuterMostParanthesis();
        String ans = obj.removeOuterParentheses(s);
        System.out.println(ans);
    }
}
