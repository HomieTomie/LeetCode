class Solution {
    //BFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> toVisit = new LinkedList<>(Arrays.asList(0));
        while (!toVisit.isEmpty() && (visited.size() != rooms.size())){
            Integer i = toVisit.poll();
            if (!visited.contains(i)){
                visited.add(i);
                for(int in: rooms.get(i)) if(!visited.contains(in)) toVisit.add(in);
            }
        }
        return visited.size() == rooms.size();
    }

    // //DFS
    // HashSet<Integer> visited = new HashSet<>();

    // public boolean canVisitAllRooms(List<List<Integer>> rooms){
    //     enterRoom(0, rooms);
    //     return visited.size() == rooms.size();
    // }

    // void enterRoom(int i, List<List<Integer>> rooms){
    //     visited.add(i);
    //     for (int key: rooms.get(i)) if(!visited.contains(key)) enterRoom(key, rooms);
    // }
}