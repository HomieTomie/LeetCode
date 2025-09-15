class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int counter = 0, newWord = 1;
        for (int i=0; i<text.length(); i++){
            if (brokenLetters.contains(String.valueOf(text.charAt(i)))) newWord = 0;
            if (text.charAt(i) == ' ' || i==text.length()-1){
                if (newWord==1) counter++;
                newWord =1;
            } 
        }
        return counter;
    }
}