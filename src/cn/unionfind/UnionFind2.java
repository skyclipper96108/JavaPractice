package cn.unionfind;

/**
 * ���
 * O(log*n)����ΪO(1)����
 */
public class UnionFind2 implements UF{

    private final int[] parent;

    //����ÿ����rank(���)�������ϲ��߼�
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

    //���ҹ��̣�����Ԫ��p����Ӧ�ļ��ϱ��
    //O(h)���Ӷ�
    private int find0(int p ){
        if(p<0 && p>=parent.length){
            throw new IllegalArgumentException("index out of bound");
        }
        while(p!=parent[p]){
            //·��ѹ���Ż� (���Ӹ��Ż���rank�Ͳ�����߶�)
            parent[p]=parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    //�ڶ���·��ѹ���Ż�
    private int find(int p ){
        if(p<0 && p>=parent.length){
            throw new IllegalArgumentException("index out of bound");
        }
        while(p!=parent[p]){
            //·��ѹ���Ż� (���Ӹ��Ż���rank�Ͳ�����߶�)
            parent[p]=find(parent[p]);
        }
        return parent[p];
    }

    //�鿴Ԫ��p��Ԫ��q�Ƿ�������һ������
    //O(h)���Ӷ�
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    //�ϲ�Ԫ��p��Ԫ��q�����ļ���
    //O(h)���Ӷ�
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot)return;
        // ��������Ԫ����������rank��ͬ�жϺϲ�����
        // ��rank�ļ��Ϻϲ���rank�ļ�����
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
