package cn.kevin.leetcode;


public class LC038 {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String p = countAndSay(n-1);
        StringBuilder builder = new StringBuilder();
        char[] chars = p.toCharArray();
        char current = chars[0];
        int count = 0;
        for (char a : chars) {
            if (a != current) {
                builder.append(count).append(current);
                current = a;
                count = 0;
            }
            count++;
        }
        builder.append(count).append(current);
        return builder.toString();
    }
}
