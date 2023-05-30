package cn.set;
import java.util.TreeSet;
/**
 * ����һ�������б�ÿ�����ʿ���д��ÿ����ĸ��ӦĦ��˹�������ϡ�
 * ���磬"cab" ����д�� "-.-..--..."��(�� "-.-." + ".-" + "-..." �ַ����Ľ��)�����ǽ�����һ�����ӹ��̳������ʷ��롣
 * �������ǿ��Ի�����дʲ�ͬ���ʷ����������
 */
public class LC804 {
	public int uniqueMorseRepresentations(String[] words) {
		String[] code= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		TreeSet<String> set=new TreeSet<>();
		for(String word:words) {
			StringBuilder res = new StringBuilder();
			for(int i=0; i<word.length();i++)
				res.append(code[word.charAt(i)-'a']);
			set.add(res.toString());
		}
		return set.size();
    }
}
