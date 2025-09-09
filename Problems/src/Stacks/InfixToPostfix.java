package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class InfixToPostfix {

    public static String infixToPostfix(String s) {
        if(s.length() == 1){
            return s;
        }
        char[] charArr = s.toCharArray();
        StringBuilder ans  = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i] == '(' || charArr[i]==')'){
                continue;
            }
            if(charArr[i] != '+' && charArr[i] != '-' && charArr[i] != '*' && charArr[i] != '/'){
                ans.append(charArr[i]);
            }
            else{
                if(stack.isEmpty()){
                    stack.push(charArr[i]);
                }
                else if(charArr[i] == '+' || charArr[i] == '-'){

                        while(stack.size()> 0 && (stack.peek() != '*' || stack.peek() != '/' || stack.peek() != '^')){
                            ans.append(stack.pop());
                        }
                        stack.push(charArr[i]);

                }
                else {
                        while(stack.size()> 0 && (stack.peek() == '^' ||stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '-' || stack.peek() == '+')){
                            ans.append(stack.pop());
                        }
                        stack.push(charArr[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        InfixToPostfix obj = new InfixToPostfix();
        System.out.println(obj.infixToPostfix(s));
    }

}
