package tech.sylardaemon;

public class Solution67 {
    public String addBinary(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();
        char[] data = new char[a_len > b_len ? a_len + 1 : b_len + 1];
        int a_index = a_len - 1;
        int b_index = b_len - 1;
        boolean step = false;
        int temp;
        for (int i = data.length - 1; i > 0; --i){
            if (a_index < 0){
                temp = (b.charAt(b_index) - '0') + (step ? 1 : 0);
                step = temp == 2;
                data[i] = temp == 1 ? '1' : '0';
                --b_index;
            }else if (b_index < 0){
                temp = (a.charAt(a_index) - '0') + (step ? 1 : 0);
                step = temp == 2;
                data[i] = temp == 1 ? '1' : '0';
                --a_index;
            }else{
                temp = (a.charAt(a_index) - '0') + (b.charAt(b_index) - '0') + (step ? 1 : 0);
                step = temp >= 2;
                temp = step ? (temp - 2) : temp;
                data[i] = temp == 1 ? '1' : '0';
                --a_index;
                --b_index;
            }
        }
        if (step){
            data[0] = '1';
            return new String(data);
        }else{
            return new String(data).substring(1);
        }
    }
}
