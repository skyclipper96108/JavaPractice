package cn.kevin.leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * ����һ���ַ���path ����ʾָ��ĳһ�ļ���Ŀ¼��Unix������·�� ���� '/' ��ͷ�������㽫��ת��Ϊ���Ӽ��Ĺ淶·����
 *
 * ��Unix�����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..����ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼����
 * ���߶������Ǹ������·������ɲ��֡�������������б�ܣ�����'//'��������Ϊ����б�� '/' �� ���ڴ����⣬�κ�������ʽ�ĵ㣨���磬'...'��������Ϊ�ļ�/Ŀ¼���ơ�
 *
 * ��ע�⣬���ص� �淶·�� ������ѭ������ʽ��
 *
 * ʼ����б�� '/' ��ͷ��
 * ����Ŀ¼��֮�����ֻ��һ��б�� '/' ��
 * ���һ��Ŀ¼����������ڣ����� �� '/' ��β��
 * ���⣬·���������Ӹ�Ŀ¼��Ŀ���ļ���Ŀ¼��·���ϵ�Ŀ¼���������� '.' �� '..'����
 * ���ؼ򻯺�õ��� �淶·�� ��
 *
 */
public class LC071 {


    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for(String s:split){
            if("..".equals(s)){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else if(s.length()>0&&!".".equals(s)){
                queue.offer(s);
            }
        }
        StringBuilder res = new StringBuilder();
        if(queue.isEmpty()){
            res.append("/");
        }
        while (!queue.isEmpty()){
            res.append("/");
            res.append(queue.poll());
        }
        return res.toString();
    }
}
