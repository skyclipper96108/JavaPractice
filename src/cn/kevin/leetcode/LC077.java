package cn.kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC077 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return res;
    }

    private void dfs(int l,int r, int k) {
        if(k>r-l+1){
            return;
        }
        if(k==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        //选择l或者不选择
        tmp.add(l);
        dfs(l+1,r,k-1);
        tmp.remove(tmp.size()-1);
        dfs(l+1,r,k);
    }
}
