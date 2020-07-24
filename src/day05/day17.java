package day05;

import java.util.Stack;

public class day17 {
    //peek是返回栈顶元素 但不在堆栈中删除它
    //pop是返回栈顶元素 并在进程中删除它
    private Stack<Integer> data_stack = new Stack<>();//数据栈
    private Stack<Integer> min_stack = new Stack<>();//辅助栈
    public void push(int node) {
        data_stack.push(node) ;
        if (min_stack.empty()||node<min_stack.peek()) {//辅助栈为空或者插入数据小于辅助栈栈顶
            min_stack.push(node);//在辅助栈中加入数据
        }else{//辅助栈不为空并且数据大于等于辅助栈的栈顶
            min_stack.push(min_stack.peek());//辅助栈插入的是自身的栈顶数据
        }
    }
    public void pop() {
        data_stack.pop();//弹栈
        min_stack.pop();//都pop 元素个数就相等
    }
    public int top() {
        return data_stack.peek();//返回的是数据栈的栈顶
    }
    public int min() {
        return min_stack.peek();//返回的是辅助栈的栈顶
    }
}
