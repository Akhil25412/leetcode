import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped array

        for (int val : pushed) {
            stack.push(val);

            // Pop while top matches the next element in popped
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, the sequence is valid
        return stack.isEmpty();
    }
}
