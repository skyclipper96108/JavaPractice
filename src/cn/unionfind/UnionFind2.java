package cn.unionfind;

/**
 * 并差集
 * O(log*n)近乎为O(1)级别
 */
public class UnionFind2 implements UF{

    private final int[] parent;

    //基于每棵树rank(深度)来决定合并逻辑
    private final int[] rank;

    public UnionFind2(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h)复杂度
    private int find0(int p ){
        if(p<0 && p>=parent.length){
            throw new IllegalArgumentException("index out of bound");
        }
        while(p!=parent[p]){
            //路径压缩优化 (增加该优化后rank就不代表高度)
            parent[p]=parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    //第二版路径压缩优化
    private int find(int p ){
        if(p<0 && p>=parent.length){
            throw new IllegalArgumentException("index out of bound");
        }
        while(p!=parent[p]){
            //路径压缩优化 (增加该优化后rank就不代表高度)
            parent[p]=find(parent[p]);
        }
        return parent[p];
    }

    //查看元素p和元素q是否所属于一个集合
    //O(h)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    //合并元素p和元素q所属的集合
    //O(h)复杂度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot)return;
        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank的集合合并到rank的集合上
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
        }else if(rank[pRoot]>rank[qRoot]) {
            parent[qRoot]=pRoot;
        }else {
            parent[qRoot]=pRoot;
            rank[pRoot]+=1;
        }

    }
}
