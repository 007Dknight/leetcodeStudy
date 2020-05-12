package com.knight.official.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 *
 * Constraints:
 *
 *     Methods pop, top and getMin operations will always be called on non-empty stacks.
 *
 *
 * 每push一个值，把它和list里面最小的值比较，在list里追加一个他俩小的值。
 * @Auther knight
 * @Created At 2020/5/12-22:03
 */
public class MinStack155 {
    class MinStack {
        List<Integer> minList = new ArrayList<>();
        List<Integer> stackList = new ArrayList<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            stackList.add(x);
            if(null == minList || minList.size() == 0){
                minList.add(x);
            }else {
                Integer temp = minList.get(minList.size() - 1);
                if(temp > x){
                    minList.add(x);
                }else {
                    minList.add(temp);
                }
            }
        }

        public void pop() {
            if(null == minList || minList.size() == 0){
                return;
            }
            minList.remove(minList.size()-1);

            if(null == stackList || stackList.size() == 0){
                return;
            }
            stackList.remove(stackList.size()-1);

        }

        public int top() {
            if(null == stackList || stackList.size() == 0){
                return -1;
            }
            return stackList.get(stackList.size()-1);
        }

        public int getMin() {
            return minList.get(minList.size()-1);
        }
    }

    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println(minStack.getMin());
    }
    public static void main(String[] args) {
        MinStack155 minStack155 = new MinStack155();
        minStack155.test();

    }

}
