import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;


public class SortMapExample {

	public static void main(String[] args) {
		Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        
        System.out.println("ORIGINAL MAP : "+unsortMap);
        Map<String, Integer> result = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        				(oldValue, newValue)->oldValue, LinkedHashMap::new));
        
        System.out.println("SORTED MAP BY KEYS	: "+result);
        
        //Alternative to sorting a map
        Map<String, Integer> result2 = new LinkedHashMap<String, Integer>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x->result2.put(x.getKey(), x.getValue()));
        System.out.println("ALTERNAATIVE SORTING KEYS	: "+result2);
        
        //sort by Value in reverse order
        Map<String, Integer> valueSortReverse = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
        		collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, NewValue)-> oldValue, LinkedHashMap::new));
        System.out.println("SORTED MAP BY VALUES IN REVERSE ORDER	: "+valueSortReverse);
        
        //sort by values using alternate way in reversed order
        Map<String, Integer> alternateSortValues = new LinkedHashMap<String, Integer>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x->alternateSortValues.put(x.getKey(), x.getValue()));
        System.out.println("ALTERNAATIVE SORTING VALUES	: "+alternateSortValues);
        
        // sort the Map<Object,Object> directly
        Properties properties = System.getProperties();
        
        Set<Entry<Object, Object>> entries = properties.entrySet();
        
        LinkedHashMap<String, String> collect = entries.stream().collect(Collectors.toMap(k->(String)k.getKey(), v->(String)v.getValue())).entrySet()
        		.stream().sorted(Map.Entry.comparingByKey()).
        		collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)->oldValue, LinkedHashMap::new));
        System.out.println("SORTED SYSTEM PROPERTIES");
        collect.forEach((k,v)->System.out.println(k+" : "+v));
	}

}
