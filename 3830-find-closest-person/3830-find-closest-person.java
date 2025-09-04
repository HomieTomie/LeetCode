class Solution {
    public int findClosest(int x, int y, int z) {
        // if (Math.abs(z-x)<Math.abs(z-y)) return 1;
        // else if (Math.abs(z-y)<Math.abs(z-x)) return 2;
        // else return 0;

        // return (Math.abs(z-x)<Math.abs(z-y)) ? 1 : ((Math.abs(z-y)<Math.abs(z-x))? 2 : 0);

        int d = (x-y) * (x + y - 2 * z);
        return (d!=0 ? 1: 0) << (d > 0 ? 1 : 0);
    }
}