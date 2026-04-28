import java.util.*;

class Solution {
    public String longestNiceSubstring(String s) {
        return helper(s);
    }

    private String helper(String s) {
        if (s.length() < 2) return "";

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if both cases exist
            if (set.contains(Character.toLowerCase(c)) &&
                set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // Split and recurse
            String left = helper(s.substring(0, i));
            String right = helper(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }

        // If all characters are valid
        return s;
    }
}