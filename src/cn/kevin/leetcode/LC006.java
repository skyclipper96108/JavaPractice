package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ��� Z �������С�
 */
public class LC006 {

    public String convert(String s, int numRows) {
        if(numRows<2){
            //����С��2ֱ�ӷ���
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            list.add(new StringBuilder());
        }
        //����������
        int i = 0; int flag=-1;
        for(char c: s.toCharArray()){
            //���鲻��Խ��
            list.get(i).append(c);
            //�����ʼΪ���£�һ��ʼ���ߵ�����β����
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder l:list){
            res.append(l.toString());
        }
        return res.toString();
    }
}
