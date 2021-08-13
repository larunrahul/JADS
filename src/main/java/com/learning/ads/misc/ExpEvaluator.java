package com.learning.ads.misc;

import java.util.Stack;

public class ExpEvaluator {
    private static int evaluate(String exp){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int num = 0;
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if(i == exp.length() - 1 || !Character.isDigit(c)){
                if(num != 0)
                    numStack.push(num);
                if(c == '('){
                    opStack.push(c);
                }else if(c == ')'){
                    if(opStack.peek() == '('){
                        opStack.pop();
                    }else {
                        if(!opStack.isEmpty() && opStack.peek() == '*'){
                            numStack.push(numStack.pop() * numStack.pop());
                            opStack.pop();
                        }
                        int csum = 0;
                        while(!opStack.isEmpty() && opStack.peek() != '('){
                            csum += numStack.pop();
                            opStack.pop();
                        }
                        if(!opStack.isEmpty()){
                            csum += numStack.pop();
                            opStack.pop();
                        }
                        
                        numStack.push(csum);
                        if(!opStack.isEmpty() && opStack.peek() == '*'){
                            System.out.println(numStack);
                            numStack.push(numStack.pop() * numStack.pop());
                            opStack.pop();
                        }
                    }
                }else {
                    if(!opStack.isEmpty() && opStack.peek() == '*'){
                        opStack.pop();
                        numStack.push(numStack.pop() * numStack.pop());
                    }
                    if(!Character.isDigit(c))
                        opStack.push(c);
                }
                num = 0;
            }
        }
        int ans = 0;
        while(!numStack.isEmpty()){
            ans += numStack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("((2)+(2+3)*5)"));
        System.out.println(evaluate("((2))"));
    }
}
