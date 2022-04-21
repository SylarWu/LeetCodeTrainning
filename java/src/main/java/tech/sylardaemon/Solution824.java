package tech.sylardaemon;

public class Solution824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuffer appending = new StringBuffer("a");
        for (int i = 0; i < words.length; ++i){
            StringBuffer temp = new StringBuffer();
            if (isVowelStart(words[i])){
                temp.append(words[i]);
            }else {
                temp.append(words[i].substring(1));
                temp.append(words[i].charAt(0));
            }
            temp.append("ma");
            temp.append(appending);
            appending.append("a");
            words[i] = temp.toString();
        }
        StringBuffer result = new StringBuffer();
        for (String word: words){
            result.append(" ");
            result.append(word);
        }
        return result.substring(1);
    }

    private boolean isVowelStart(String word){
        switch (word.charAt(0)){
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
        }
        return false;
    }
}
