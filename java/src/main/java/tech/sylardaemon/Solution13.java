package tech.sylardaemon;

public class Solution13 {
    public int romanToInt(String s) {
        char[] data = s.toCharArray();
        int res = 0;
        for (int i = 0; i < data.length; ++i){
            switch (data[i]){
                case 'M':
                    if (i > 0 && data[i - 1] == 'C'){
                        res += 800;
                    }else{
                        res += 1000;
                    }
                    break;
                case 'D':
                    if (i > 0 && data[i - 1] == 'C'){
                        res += 300;
                    }else{
                        res += 500;
                    }
                    break;
                case 'C':
                    if (i > 0 && data[i - 1] == 'X'){
                        res += 80;
                    }else{
                        res += 100;
                    }
                    break;
                case 'L':
                    if (i > 0 && data[i - 1] == 'X'){
                        res += 30;
                    }else{
                        res += 50;
                    }
                    break;
                case 'X':
                    if (i > 0 && data[i - 1] == 'I'){
                        res += 8;
                    }else{
                        res += 10;
                    }
                    break;
                case 'V':
                    if (i > 0 && data[i - 1] == 'I'){
                        res += 3;
                    }else{
                        res += 5;
                    }
                    break;
                default:
                    res += 1;
            }
        }
        return res;
    }
}
