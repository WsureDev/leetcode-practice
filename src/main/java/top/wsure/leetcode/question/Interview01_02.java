package top.wsure.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/*
    FileName:   Interview01_02
    Author:     wsure
    Date:       2022/9/27
    Description:
*/
public class Interview01_02 {
    public static void main(String[] args) {
        System.out.println(new Solution().CheckPermutation("1223","3121"));
    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if ((s1 == null || s2 == null) || (s1.length() != s2.length())) {
            return false;
        }
        int N = s1.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int count1 = map.getOrDefault(s1.charAt(i),0);
            map.put(s1.charAt(i),count1 +1);
            int count2 = map.getOrDefault(s2.charAt(i),0);
            map.put(s2.charAt(i),count2 -1);
        }
        for(Integer count : map.values()){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

}
