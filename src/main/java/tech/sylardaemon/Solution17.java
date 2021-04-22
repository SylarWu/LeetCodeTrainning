package tech.sylardaemon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution17 {
    private static final HashMap<Character,Character[]> base = new HashMap<>();

    static {
        base.put('1',new Character[]{});
        base.put('2',new Character[]{'a','b','c'});
        base.put('3',new Character[]{'d','e','f'});
        base.put('4',new Character[]{'g','h','i'});
        base.put('5',new Character[]{'j','k','l'});
        base.put('6',new Character[]{'m','n','o'});
        base.put('7',new Character[]{'p','q','r','s'});
        base.put('8',new Character[]{'t','u','v'});
        base.put('9',new Character[]{'w','x','y','z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        backTrace(digits,res,0,new StringBuilder());
        return res;
    }

    private void backTrace(String digits, List<String> res,int index,StringBuilder temp){
        if (index == digits.length()){
            res.add(temp.toString());
        }else{
            for (int i = 0;i < base.get(digits.charAt(index)).length; ++i){
                temp.append(base.get(digits.charAt(index))[i]);
                backTrace(digits,res,index + 1,temp);
                temp.deleteCharAt(index);
            }
        }
    }

    private List<String> firstInMyHead(String digits){
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        int n = digits.length();
        List<String> res = new LinkedList<>();
        int[] mark = new int[n];
        StringBuilder temp;
        boolean flag = true;
        while (flag){
            temp = new StringBuilder();
            for (int i = 0; i < n; ++i){
                temp.append(base.get(digits.charAt(i))[mark[i]]);
            }
            res.add(temp.toString());
            int j = n - 1;
            ++mark[j];
            while (mark[j] >= base.get(digits.charAt(j)).length){
                mark[j] = 0;
                --j;
                if (j < 0){
                    flag = false;
                    break;
                }
                ++mark[j];
            }
        }
        return res;
    }
}
