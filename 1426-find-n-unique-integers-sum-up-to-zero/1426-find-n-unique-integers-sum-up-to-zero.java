class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int first = 1, second = 1;
        if (n%2==1) second = 0;
        for (int i = 0; i<ans.length; i++){
            if(second!=first){
                ans[i] = second;
                second++;
            } else {
                ans[i] = -first;
                first++;
            }
        }
        return ans;
    }
}