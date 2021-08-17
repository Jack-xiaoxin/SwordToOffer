package leetcodeeveryday;

public class Q0817 {

    public static void main(String[] args) {
        System.out.println(new Q0817().checkRecord("PPALLL"));
    }

    public boolean checkRecord(String s) {
        if(s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL")) return false;
        else return true;
    }
}
