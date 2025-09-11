class Solution {
    public String sortVowels(String s) {
        char[] charArr = s.toCharArray(), vowelArr = new char[s.length()];
        int increment = 0;
        for (char c: charArr){
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')  {
                vowelArr[increment] = c;
                increment++;
            }
        } 
        char[] tempArr = new char[increment];
        for(int i=0; i<tempArr.length; i++){
            tempArr[i] = vowelArr[i];
        }
        Arrays.sort(tempArr);
        increment = 0;
        for(int i = 0; i<charArr.length; i++){
            if (charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u' || charArr[i] == 'A' || charArr[i] == 'E' || charArr[i] == 'I' || charArr[i] == 'O' || charArr[i] == 'U'){
                charArr[i] = tempArr[increment];
                increment++;
            }
        }
        return String.valueOf(charArr);
    }
}