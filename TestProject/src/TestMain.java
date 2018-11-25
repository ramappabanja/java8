import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nisum
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ganacharyya";
		Stream<Character> stringStream = str.chars().mapToObj(item -> (char)item);
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		stringStream.forEach(c->{
			Integer value = map.get(c);
			if(value==null){
				map.put(c, 1);
			}else{
				map.put(c, value+1);
			}
		});
		
		System.out.println("MAP IS	: "+map);
		
//		List<Integer> collect = map.entrySet().stream().map(x->x.getValue()).filter(v-> v==1)
		 List<Character> list = map.entrySet().stream().filter(entry -> entry.getValue()==1)
				.map(entry->entry.getKey()).collect(Collectors.toList());
//		System.out.println("======="+list);
		
		Map<Character, Long> collect = str.chars().mapToObj(item -> (char)item).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println("groupingBy COLLECT	: " + collect);
		
		Map<Character, Long> collect1 = str.chars().mapToObj(item -> (char)item).collect(Collectors.groupingBy(Character::charValue,LinkedHashMap::new,Collectors.counting()));
		System.out.println("groupingBy COLLECT	: " + collect1);
		
//		Map<Character, Long> collect = str.chars().mapToObj(item -> (char)item).collect(Collectors.toMap(Function.identity(), Collectors.counting(), (oldValue, newValue)->oldValue), LinkedHashMap::new);
//		System.out.println("groupingBy COLLECT	: " + collect);
//		System.out.println("collect : "+collect);
//		Map<char[], Long> collect2 = Arrays.asList(str.toCharArray()).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println("collect2 is : "+collect2);
		
//		for(char ch : str.toCharArray()){
//			if(str.indexOf(ch)!=str.lastIndexOf(ch))
//				str=str.replace(ch+"", "");
//		}
//		System.out.println("STRING IS : "+str);
//		System.out.println("CHAR AT is : "+Character.toString(str.charAt(0)));
		
		System.out.println(str.chars().mapToObj(c->(char)c).filter(c->str.indexOf(c)==str.lastIndexOf(c))
				.collect(Collectors.toList()).get(2));
	}
	
	
}