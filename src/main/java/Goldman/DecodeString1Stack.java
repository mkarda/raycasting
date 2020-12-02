package Goldman;

import java.util.Stack;

public class DecodeString1Stack {


    public static void main(String[] args) {
//        String[] input = {"1[b]", "2[ab]", "3[b2[ca]]"};
        String[] input = {"3[b2[ca]]"};

        for (String encoded : input) {
            System.out.println(decode(encoded));
        }
    }

    private static String decode(String encodedStr) {
        Stack<Character> decodeStack = new Stack<>();
        char[] charArr = encodedStr.toCharArray();
        for (char c : charArr) {
            decodeStack.push(c);
        }
        StringBuilder strBuff = new StringBuilder();
        String resultString ="";
        while (!decodeStack.isEmpty()) {
            char ch = decodeStack.pop();
            if (ch == ']' || ch == '[') {
                continue;
            }  else if (Character.isDigit(ch)) {
                resultString =appendNTimes(strBuff.toString(), Character.getNumericValue(ch));
                strBuff.setLength(0);
                strBuff.append(resultString);
            } else {
                strBuff.insert(0,ch);
            }
        }

        return resultString;
    }

    private static String appendNTimes(String s, int n) {
        StringBuffer strBuff = new StringBuffer();
        for (int i=0; i < n; i++) {
            strBuff.append(s);
        }
        return strBuff.toString();
    }
}
