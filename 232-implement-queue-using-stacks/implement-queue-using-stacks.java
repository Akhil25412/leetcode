import java.util.Stack;

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    // Push element to the back of the queue
    public void push(int x) {
        inStack.push(x);
    }
    
    // Removes the element from the front of the queue and returns it
    public int pop() {
        moveInToOut();
        return outStack.pop();
    }
    
    // Get the front element
    public int peek() {
        moveInToOut();
        return outStack.peek();
    }
    
    // Return true if the queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    // Helper: move elements from inStack to outStack if outStack is empty
    private void moveInToOut() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
