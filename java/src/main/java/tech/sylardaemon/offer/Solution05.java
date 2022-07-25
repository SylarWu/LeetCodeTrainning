package tech.sylardaemon.offer;

public class Solution05 {
    public String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == ' ') {
                buffer.append("%20");
            }else{
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }
}
