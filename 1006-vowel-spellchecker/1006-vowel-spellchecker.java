class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries){
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> capitalization = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();
        String[] result = new String[queries.length];

        for(String word : wordlist){
            capitalization.putIfAbsent(word.toLowerCase(), word);
            vowelError.putIfAbsent(word.toLowerCase().replaceAll("[aeiou]", "\\$"), word);
        }

        for (int i = 0; i<queries.length;i++){
            if(exact.contains(queries[i])) result[i] = queries[i];
            else if (capitalization.containsKey(queries[i].toLowerCase())) result[i] = capitalization.get(queries[i].toLowerCase());
            else if (vowelError.containsKey(queries[i].toLowerCase().replaceAll("[aeiou]", "\\$"))) result[i] = vowelError.get(queries[i].toLowerCase().replaceAll("[aeiou]", "\\$"));
            else result[i] = "";
        }
        return result;
    }


    // public String[] spellchecker(String[] wordlist, String[] queries) {
    //     String[] result = new String[queries.length];
    //     int resultIndex = 0;
    //     for(int i = 0; i<queries.length; i++){
    //         String capitalization = "";
    //         String vowelError = "";
    //         for(int j = 0; j<wordlist.length; j++){ 
    //             if (queries[i].equals(wordlist[j])){
    //                 result[i] = queries[i];
    //                 break;
    //             } else if (queries[i].toLowerCase().equals(wordlist[j].toLowerCase()) && capitalization.equals("")) {
    //                 capitalization = wordlist[j];
    //             } else if (queries[i].toLowerCase().replaceAll("[aeiou]", "a").equals(wordlist[j].toLowerCase().replaceAll("[aeiou]", "a")) && vowelError.equals("")) {
    //                 vowelError = wordlist[j];
    //             }
    //         }
    //         if (result[i]==null){
    //             String resultAdd = !capitalization.equals("") ? capitalization : !vowelError.equals("") ? vowelError : "";
    //             result[i] = resultAdd;
    //         }
    //     }
    //     return result;
    // }
}