class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0, result = 0;
        for(int i : nums){
            map.merge(i, 1, Integer::sum);
            maxFrequency = Math.max(maxFrequency, map.get(i));
        }
        for (Integer i : map.values()) if (i==maxFrequency) result+=i;
        return result;
    }
}