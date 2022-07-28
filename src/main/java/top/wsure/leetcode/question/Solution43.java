package top.wsure.leetcode.question;

import javafx.util.Pair;

public class Solution43 {
    public String multiply(String num1, String num2) {
       String now = "0";
        for(int i = num2.length() -1;i>=0;i--){
            StringBuilder sb = new StringBuilder(mux(num1,num2.charAt(i)));
            for (int ii = 0;ii< num2.length() -1-i;ii++){
                sb.append('0');
            }
            now = add(now,sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (int i=0;i<now.length();i++){
            start = start && now.charAt(i) == '0';
            if(start && i != now.length() -1){
                continue;
            }
            sb.append(now.charAt(i));
        }
        return sb.toString();
    }

    public String mux(String row,char a){
        StringBuilder sb = new StringBuilder();
        char left = '0';
        for(int i = row.length() -1;i >= 0 ; i --){
            Pair<Character,Character> pair = mux(row.charAt(i),a);
            Pair<Character,Character> leftPair = add(pair.getValue(),left);
            Pair<Character,Character> nextLeft = add(pair.getKey(),leftPair.getKey());
            left = nextLeft.getValue();
            sb.insert(0,leftPair.getValue());
        }
        if(left != '0'){
            sb.insert(0,left);
        }
        return sb.toString();
    }
// 99
// 99
    public String add(String row,String a){
        StringBuilder sb = new StringBuilder();
        char left = '0';
        int length = Math.max(row.length(),a.length());
        for(int i = 1;i <= length ; i ++){
            char c1 = row.length() - i >= 0 ? row.charAt(row.length()-i) : '0';
            char c2 = a.length() - i >= 0 ? a.charAt(a.length()-i) : '0';
            Pair<Character,Character> pair = add(c1,c2);
            Pair<Character,Character> leftPair = add(pair.getValue(),left);
            Pair<Character,Character> nextLeft = add(pair.getKey(),leftPair.getKey());
            left = nextLeft.getValue();
            sb.insert(0,leftPair.getValue());
        }
        if(left != '0'){
            sb.insert(0,left);
        }
        return sb.toString();
    }
    public Pair<Character,Character> add(char a,char b){
        String res = String.valueOf((a - '0') + (b - '0'));
        if(res.length() == 2){
            return new Pair<>(res.charAt(0),res.charAt(1));
        } else {
            return new Pair<>('0',res.charAt(0));
        }
    }

    public Pair<Character,Character> mux(char a,char b){
        String res = String.valueOf((a - '0') * (b - '0'));
        if(res.length() == 2){
            return new Pair<>(res.charAt(0),res.charAt(1));
        } else {
            return new Pair<>('0',res.charAt(0));
        }
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.mux("123",'3'));
        System.out.println(solution43.add("123","123"));
        System.out.println(solution43.multiply("123","456"));
        System.out.println(solution43.multiply("999","999"));
        System.out.println(solution43.multiply("99999999999999999999999999999999999999999999999","99999999999999999999999999999999999999999999999"));
    }

}

