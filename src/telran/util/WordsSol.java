package telran.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordsSol implements Words {
	
	HashSet<String> dictionary = new HashSet<>();
	
	@Override
	public boolean addWord(String word) {
		return dictionary.add(word);
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		LinkedList<String> list = new LinkedList<>();
		dictionary.stream().filter(x -> x.startsWith(prefix)).forEach(list::add);
		
		return list;
	}

}
