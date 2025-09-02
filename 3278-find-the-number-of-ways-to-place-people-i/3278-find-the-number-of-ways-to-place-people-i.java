class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0]!=b[0]){
                return Integer.compare(b[0], a[0]); 
            } else {
                return Integer.compare(a[1], b[1]) ;
            }
        });

        int n = points.length;
        int ans = 0;

        for (int i = 0; i<n-1; i++){
            int y = Integer.MAX_VALUE;
            int yi = points[i][1];

            for (int j = i + 1; j<n; j++){
                int yj = points[j][1];

                if(yj >= yi && y > yj){
                    ans++;
                    y = yj;
                }
            }
        }
        return ans;
    }
}