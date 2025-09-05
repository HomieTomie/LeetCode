class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        //This solution does not work as it is greedy, meaning that we do the same operation over and over and in the final steps we can subtract too little, hence our answer won't work properly
        // int counter = 1;
        // Set<Integer> seen = new HashSet<>();

        // while (true) {
        //     if (num1 < num2) return -1;
        //     int power = Math.min(((num1 - num2) / 2), 60);
        //     if (power < 0) return -1;

        //     int next = num1 - ((int)Math.pow(2, power) + num2);

        //     if (next == 0) return counter;
        //     if (seen.contains(next)) return -1;

        //     seen.add(next);
        //     num1 = next;
        //     counter++;
        // }

        for (int k=1; k<60;k++){
            long x = (long)num1 - k * (long)num2;
            if(x<k) continue;
            if(Long.bitCount(x) <= k) return k;
        }
        return -1;
    }
}
