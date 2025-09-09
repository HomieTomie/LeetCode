class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // List<List<Integer>> people = new ArrayList<>(Arrays.asList(Arrays.asList(delay, forget)));
        // int counter = 0;
        // while (people.size()<n){
        //     List<List<Integer>> temp = new ArrayList<>(people);
        //     for (List<Integer> l: temp){
        //         if (l.get(0)!=0) l.set(0, l.get(0)-1);
        //         else if (l.get(1)==0) people.remove(l);
        //         else {
        //             people.add(Arrays.asList(delay, forget));
        //             l.set(1, l.get(1)-1);
        //         }
        //     }
        //     counter++;
        //     people = temp;
        // }
        // return counter;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long share = 0, MOD = (long)1e9 + 7;
        for (int t = 2; t <= n; t++) {
            if (t - delay > 0)
                share = (share + dp[t - delay] + MOD) % MOD;
            if (t - forget > 0)
                share = (share - dp[t - forget] + MOD) % MOD;
            dp[t] = share;
        }

        long know = 0;
        
        for (int i = n - forget + 1; i <= n; i++)
            know = (know + dp[i]) % MOD;
        
        return (int)know;
    }
}