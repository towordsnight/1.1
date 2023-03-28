import java.util.*;

public class hw {
    public String decodeString(String s) {
        StringBuilder curString = new StringBuilder();
//        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numsStack = new Stack<Integer>();
        int currNum = 0;
        for (char c:s.toCharArray() ){
            if (Character.isDigit(c)){
                currNum = currNum * 10 + (c - '0');
            }else if(c == '['){
                numsStack.push(currNum);
                currNum = 0;
                strStack.push(curString);
                curString = new StringBuilder();
            }else if(c == ']'){
                StringBuilder temp = curString;
                curString=strStack.pop();
                int repeatTimes = numsStack.pop();
                for(int i=0;i<repeatTimes;i++){
                    curString.append(temp);
                }
            }else {
                curString.append(c);
            }
        }

        return curString.toString();
    }

    public static void main(String[] args) {
    }
}
