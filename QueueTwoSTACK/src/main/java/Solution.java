import java.util.Stack;

public class Solution {
    public static class MyQueue<T>{
        private Stack<T> stackNewestOnTop = new Stack<T>();
        private Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue (T value){
            //Add item
            stackNewestOnTop.push(value);
        }

        public T peek(){
            //get oldest item
            //move elements from stackNewest to stackOldest
            shiftStacks();
            return stackOldestOnTop.peek();
            //move elements back
        }

        private void shiftStacks(){
            if(stackOldestOnTop.isEmpty()){
                while (!stackNewestOnTop.isEmpty()){
                    stackNewestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }

        public T dequeue(){
            //get oldest item and remove it
            //move elements from stackNewest to stackOldest
            return stackOldestOnTop.pop();
        }
    }
    public static void  main(String[] args){
        System.out.println("TEST");
    }
}
