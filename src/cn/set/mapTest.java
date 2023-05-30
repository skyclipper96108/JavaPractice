package cn.set;
import java.util.ArrayList;

public class mapTest {
	public static void main(String[] args) {
		System.out.println("The Count of Monte Cristo");
		ArrayList<String> words=new ArrayList<>();
		if(FileOperation.readFile("resources/The Count of Monte Cristo.txt", words)) {
			System.out.println("Total words: "+words.size());
			BSTmap<String, Integer> map=new BSTmap<>();
			for(String word: words) {
				if(map.contains(word))
					map.set(word, map.get(word)+1);
				else map.add(word, 1);
			}
			System.out.println("Total different words: "+map.getSize());
			System.out.println("Frequency of count: "+map.get("count"));
		}
		
	}

}
