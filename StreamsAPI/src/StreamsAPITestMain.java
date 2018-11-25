import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAPITestMain {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,66,88,100, 201, 20, 45);
		System.out.println("LIST OF INTEGERS : "+list);
		
		List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
		System.out.println("SORTED LIST IN ASCENDING ORDER: "+list1);		
		
		list1 = list.stream().sorted((i,j)-> j.compareTo(i)).collect(Collectors.toList());
		System.out.println("SORTED LIST IN DESCENDING ORDER: "+list1);		
		
		Integer min = list.stream().min((i,j)->i.compareTo(j)).get();
		System.out.println("MINIMUM NUMBER : "+min);
		
		Integer max = list.stream().min((i,j)->j.compareTo(i)).get();
		System.out.println("MAXIMUM NUMBER : "+max);
		
		System.out.println("FOR EACH LOOP");
		list.stream().forEach(System.out::println);
		
		System.out.println("ORDERED FOR EACH LOOP");
		list.stream().forEachOrdered(System.out::println);
		
		System.out.println("ARRY FROM LIST");
		Object[] intArray = list.stream().toArray();
		System.out.println(intArray[3]);
		
	}
}
