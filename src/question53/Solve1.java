package question53;

import question51.Solve;

import java.util.ArrayList;
import java.util.List;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(new Solve1().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" +");
        String result = "";
        for(int i = strings.length - 1; i >= 0; i--) {
            result += strings[i];
            if(i != 0) result += " ";
        }
        return result;
    }
}
