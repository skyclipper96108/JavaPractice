package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j], nums[k]] ���� i != j��i != k �� j != k ��ͬʱ������ nums[i] + nums[j] + nums[k] == 0 ����
 *
 * �㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 *
 */
public class LC015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(length <3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0; i<length; i++){
            if(nums[i]>0){
                break;
            }
            //ȥ��
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            //����˫ָ��
            int l = i+1; int r = length-1;
            while (l<r){
                //˫ָ�벻�غ� ���ж�����֮��
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //��lָ����һλ����l����
                    while(l<length-1&&nums[l+1]==nums[l]){
                        l++;
                    }
                    //��rָ��ǰһλ����r����
                    while(r>0&&nums[r-1]==nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(sum>0){
                    //�ʹ���0����r��ǰ��
                    r--;
                }else {
                    //��С��0����l�����
                    l++;
                }

            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {

        int res=0;
        int c = Integer.MAX_VALUE;
        int length = nums.length;
        if(length <3){
            for(int n:nums){
                res+=n;
            }
            return res;
        }
        Arrays.sort(nums);
        res = nums[0]+nums[1]+nums[2];
        for(int i=0; i<length; i++){
            //ȥ��
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            //����˫ָ��
            int l = i+1; int r = length-1;
            while (l<r){
                //˫ָ�벻�غ� ���ж�����֮��
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-sum)<c){
                    res = sum;
                    c=Math.abs(target-sum);
                }
                if(sum==target){
                    return target;
                }else if(sum >target){
                    //�ʹ���0����r��ǰ��
                    r--;
                }else {
                    //��С��0����l�����
                    l++;
                }

            }
        }
        return res;

    }


}
