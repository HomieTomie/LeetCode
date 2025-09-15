class Solution {
    public int maxFreqSum(String s) {
        Map<String, Integer> vowels = new HashMap<>();
        Map<String, Integer> consonants = new HashMap<>();
        for(String str : s.split("")){
            if (str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u")){
                vowels.merge(str, 1, Integer::sum);
            } else {
                consonants.merge(str, 1, Integer::sum);
            }
        }
        int vowelsMax = vowels.isEmpty() ? 0 : Collections.max(vowels.values());
        int consonantsMax = consonants.isEmpty() ? 0 : Collections.max(consonants.values());
        return vowelsMax + consonantsMax;
    }
}