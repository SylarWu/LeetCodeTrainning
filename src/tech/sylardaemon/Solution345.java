package tech.sylardaemon;

public class Solution345 {

    private boolean isAEIOU(char x){
        switch (x){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;

        }
    }


    public String reverseVowels(String s) {
        char[] data = s.toCharArray();
        int i = 0;
        int j = data.length - 1;
        char temp;
        while (i < j){
            while (i < j && !isAEIOU(data[i])){
                ++i;
            }
            while (i < j && !isAEIOU(data[j])){
                --j;
            }
            if (i < j){
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                ++i;
                --j;
            }
        }
        return new String(data);
    }
}
