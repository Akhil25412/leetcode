import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}