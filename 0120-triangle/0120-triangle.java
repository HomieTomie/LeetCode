class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dpArray = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i>=0 ; i--){
            for (int j = 0; j<triangle.get(i).size() ; j++){
                dpArray[j] = Math.min(dpArray[j], dpArray[j+1]) + triangle.get(i).get(j);
            } 
        }
        return dpArray[0];
    }
}