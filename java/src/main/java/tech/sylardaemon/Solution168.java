package tech.sylardaemon;

public class Solution168 {



    public String convertToTitle(int columnNumber) {
        StringBuffer result = new StringBuffer();
        int r;
        while (columnNumber != 0){
            --columnNumber;
            r = columnNumber % 26;
            result.append((char) (r + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}
