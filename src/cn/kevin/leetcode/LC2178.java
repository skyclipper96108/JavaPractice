package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数finalSum。请你将它拆分成若干个互不相同 的正偶数之和，且拆分出来的正偶数数目最多。
 *
 * 比方说，给你finalSum = 12，那么这些拆分是符合要求 的（互不相同的正偶数且和为finalSum）：(2 + 10)，
 * (2 + 4 + 6)和(4 + 8)。它们中，(2 + 4 + 6)包含最多数目的整数。
 * 注意finalSum不能拆分成(2 + 2 + 4 + 4)，因为拆分出来的整数必须互不相同。
 * 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。
 * 如果没有办法将finalSum进行拆分，请你返回一个空数组。你可以按 任意顺序返回这些整数。
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
