package class2;

import java.util.Stack;

/**
 * @program: dataStructure
 * @description: 两个栈实现队列
 * @author: maple
 * @create: 2020-05-01 15:26
 **/
public class TwoStacksImplementQueue {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    void add(int v){
        if (pushStack.isEmpty()){
            while (!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
        }
        pushStack.push(v);
    }

    int poll(){
        if (pushStack.isEmpty() && popStack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    int peek(){
        if (pushStack.isEmpty() && popStack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public static void main(String[] args) {
        TwoStacksImplementQueue test = new TwoStacksImplementQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }


}
