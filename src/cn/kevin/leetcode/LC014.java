package cn.kevin.leetcode;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 *
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 */
public class LC014 {
    public String longestCommonPrefix(String[] strs) {
        //ȡ����һ���ַ���
        char[] s0 = strs[0].toCharArray();
        for(int i=0; i<s0.length;i++){
            //�������������ַ���
            for (int j=1;j<strs.length;j++){
                //���ַ���Խ�� �� �Ƚϲ�����򷵻�
                if(i==strs[j].length() || s0[i]!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}