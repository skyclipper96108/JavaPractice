package cn.set;
import java.util.TreeSet;
/**
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * 返回我们可以获得所有词不同单词翻译的数量。
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
