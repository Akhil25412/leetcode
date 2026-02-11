import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision condition:
            // stack top moving right (>0) and current moving left (<0)
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                
                if (stack.peek() < -asteroid) {
                    // Top asteroid explodes
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    // Both explode
                    stack.pop();
                }
                
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
