package com.knight.official.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2019/8/18 0:05
 */
public class ValidParentheses20 {
    public static boolean isValid1(String s) {
        if(null == s || s.length() == 0 )   return true;
        if(s.length()%2 == 1)   return false;
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '('){
                    stack.pop();
                }
            }else if(c == '['){
                if(stack.empty() || stack.peek() == '{'){
                    stack.push(c);
                }else {
                    return false;
                }
            }else if(c == ']'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '['){
                    stack.pop();
                }
            }else if(c == '{'){
                if(stack.empty()){
                    stack.push(c);
                }else {
                    return false;
                }
            }else if(c == '}'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '{'){
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static boolean isValid(String s) {
        if(null == s || s.length() == 0 )   return true;
        if(s.length()%2 == 1)   return false;
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '('){
                    stack.pop();
                }
            }else if(c == ']'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '['){
                    stack.pop();
                }
            }else if(c == '}'){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek == '{'){
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }
}
