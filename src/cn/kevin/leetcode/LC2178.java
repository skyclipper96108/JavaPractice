package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������finalSum�����㽫����ֳ����ɸ�������ͬ ����ż��֮�ͣ��Ҳ�ֳ�������ż����Ŀ��ࡣ
 *
 * �ȷ�˵������finalSum = 12����ô��Щ����Ƿ���Ҫ�� �ģ�������ͬ����ż���Һ�ΪfinalSum����(2 + 10)��
 * (2 + 4 + 6)��(4 + 8)�������У�(2 + 4 + 6)���������Ŀ��������
 * ע��finalSum���ܲ�ֳ�(2 + 2 + 4 + 4)����Ϊ��ֳ������������뻥����ͬ��
 * ���㷵��һ���������飬��ʾ��������ֳ� ��� ��Ŀ����ż�����顣
 * ���û�а취��finalSum���в�֣����㷵��һ�������顣����԰� ����˳�򷵻���Щ������
 *
 */
public class LC2178 {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if(finalSum%2>0){
            return res;
        }
        for(long i=2;i<=finalSum;i+=2){
            res.add(i);
            finalSum-=i;
        }
        if(finalSum!=0){
            long l = res.get(res.size() - 1) + finalSum;
            res.set(res.size()-1, l);
        }
        return res;
    }

}
