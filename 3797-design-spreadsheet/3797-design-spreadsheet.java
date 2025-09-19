// class Spreadsheet {
//     private int[][] table;

//     public Spreadsheet(int rows) {
//         table = new int[rows][26];
//     }
    
//     public void setCell(String cell, int value) {
//         if (checkIfCellIsInTable(cell)) table[cell.charAt(1) - '1'][cell.charAt(0) - 65] = value;
//     }
    
//     public void resetCell(String cell) {
//         if (checkIfCellIsInTable(cell)) table[cell.charAt(1) - '1'][cell.charAt(0) - 65] = 0;
//     }
    
//     public int getValue(String formula) {
//         formula = formula.substring(1);
//         String[] form = formula.split("\\+");
//         for(String s: form) System.out.println(s);
//         int x = Character.isLetter(form[0].charAt(0)) ? ( checkIfCellIsInTable(form[0]) ? table[form[0].charAt(1) - '1'][form[0].charAt(0) - 65] : 0 ) : Integer.parseInt(form[0]);
//         int y = Character.isLetter(form[1].charAt(0)) ? ( checkIfCellIsInTable(form[1]) ? table[form[1].charAt(1) - '1'][form[1].charAt(0) - 65] : 0 ) : Integer.parseInt(form[1]);
//         System.out.println("-------------------");
//         return x+y;
//     }

//     public boolean checkIfCellIsInTable(String cell){
//         return (cell.charAt(1) - '1' < table.length && cell.charAt(0) - 65 < 26);
//     }
// }

// /**
//  * Your Spreadsheet object will be instantiated and called as such:
//  * Spreadsheet obj = new Spreadsheet(rows);
//  * obj.setCell(cell,value);
//  * obj.resetCell(cell);
//  * int param_3 = obj.getValue(formula);
//  */
class Spreadsheet {
    HashMap<String, Integer> mpp = new HashMap<>();
    public Spreadsheet(int rows) {}
    public void setCell(String cell, int value) {
        mpp.put(cell, value);
    }
    public void resetCell(String cell) {
        mpp.put(cell, 0);
    }
    public int getValue(String formula) {
        formula = formula.substring(1);
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                String s1 = formula.substring(0, i), s2 = formula.substring(i + 1);
                int left = Character.isUpperCase(s1.charAt(0)) ? mpp.getOrDefault(s1, 0) : Integer.parseInt(s1);
                int right = Character.isUpperCase(s2.charAt(0)) ? mpp.getOrDefault(s2, 0) : Integer.parseInt(s2);
                return left + right;
            }
        }
        return 0;
    }
}