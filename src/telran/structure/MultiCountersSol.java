package telran.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

public class MultiCountersSol implements MultiCounters {


	HashMap<Object, Integer> mapCollection = new HashMap<>();
	TreeMap<Integer, HashSet<Object>> countOfObj = new TreeMap<>();
	
	
	@Override
	public Integer addItem(Object item) {
		Integer count = mapCollection.getOrDefault(item, 0);
		setNewCount(item, count);
		mapCollection.put(item, ++count);
		return count;
	}

	private void setNewCount(Object item, Integer count) {
		if(count != 0) {
			removeCountOfObj(item, count);
		}
		addCountOfObj(item, count + 1);
	}

	private void addCountOfObj(Object item, Integer count) {
		HashSet<Object> set = countOfObj.get(count);
		if(set == null) {
			set = new HashSet<>();
			countOfObj.put(count, set);
		}
		set.add(set);
	}

	@Override
	public Integer getValue(Object item) throws Exception {
		Integer res = mapCollection.get(item);
		if(res == null) {
			throw new NoSuchElementException();
		}
		return res;
	}

	@Override
	public boolean remove(Object item){
		boolean res = false;
		Integer count = mapCollection.remove(item);
		if(count != null) {
			removeCountOfObj(item, count);
			res = true;
		}
		return res;
	}

	private void removeCountOfObj(Object item, Integer count) {
		HashSet<Object> set = countOfObj.get(count);
		set.remove(item);
		if(set.isEmpty()) {
			countOfObj.remove(count);
		}
	}

	@Override
	public Set<Object> getMaxItems() throws Exception {
		if(mapCollection.isEmpty()){
			throw new NoSuchElementException();
		}
		return countOfObj.lastEntry().getValue();
	}

}
