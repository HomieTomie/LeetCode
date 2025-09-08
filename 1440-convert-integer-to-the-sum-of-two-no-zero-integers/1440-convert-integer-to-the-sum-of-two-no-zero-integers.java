class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n-1;
        while(String.valueOf(a).contains("0") || String.valueOf(n-a).contains("0")) a--;
        return new int[] {a, n-a};
    }
}