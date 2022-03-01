package tech.sylardaemon;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 1 || numRows == 1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < numRows; ++i){
            int cur = i;
            int step = (numRows - 1 - i) * 2;
            while (cur < n){
                if (step != 0){
                    result.append(s.charAt(cur));
                }
                cur += step;
                step = (numRows - 1) * 2 - step;
            }
        }
        return result.toString();
    }





















    private String originMethod(String s, int numRows){
        if (numRows == 1 || s == null || s.equals("")){
            return s;
        }
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int index;
        int step;
        for (int i = 0; i < numRows; ++i){
            index = i;
            step = (numRows - 1 - i) * 2;
            while (index < n){
                if (step != 0){
                    res.append(s.charAt(index));
                }
                index += step;
                step = (numRows - 1) * 2 - step;
            }
        }
        return res.toString();
    }
}
