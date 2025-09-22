class Solution {
    HashSet<Integer> visited = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i<isConnected.length; i++){
            if (!visited.contains(i)){
                dfs(isConnected, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] isConnected, int i){
        visited.add(i);
        for (int j = 0; j<isConnected.length; j++){
            if (isConnected[i][j] == 1 && !visited.contains(j)) dfs(isConnected, j);
        }
    }
}