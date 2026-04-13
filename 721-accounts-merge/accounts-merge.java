import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        // Map email -> account index
        Map<String, Integer> emailToIndex = new HashMap<>();
        
        // Step 1: Union accounts with common emails
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    uf.union(i, emailToIndex.get(email));
                }
            }
        }
        
        // Step 2: Group emails by parent
        Map<Integer, TreeSet<String>> map = new HashMap<>();
        
        for (String email : emailToIndex.keySet()) {
            int parent = uf.find(emailToIndex.get(email));
            map.putIfAbsent(parent, new TreeSet<>());
            map.get(parent).add(email);
        }
        
        // Step 3: Prepare result
        List<List<String>> result = new ArrayList<>();
        
        for (int parent : map.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0)); // name
            merged.addAll(map.get(parent)); // sorted emails
            result.add(merged);
        }
        
        return result;
    }
}

// Union-Find Class
class UnionFind {
    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // path compression
        return parent[x];
    }
    
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parent[px] = py;
    }
}