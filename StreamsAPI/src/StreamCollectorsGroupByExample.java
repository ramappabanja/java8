import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamCollectorsGroupByExample {

	public static void main(String[] args) {

		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		
		Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Group by a List and display the total count of it : "+result);
		
		//Adding the Sorting to the values of result map
		Map<String, Long> finalMap = new LinkedHashMap<String, Long>();
		
		result.entrySet().stream()
			.sorted(Map.Entry.<String,Long>comparingByValue()
					.reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println("SORTED MAP BY VALUES : "+finalMap);
		
        List<Fruit> fruits = Arrays.asList(
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 20, new BigDecimal("19.99")),
                new Fruit("orang", 10, new BigDecimal("29.99")),
                new Fruit("watermelon", 10, new BigDecimal("29.99")),
                new Fruit("papaya", 20, new BigDecimal("9.99")),
                new Fruit("apple", 10, new BigDecimal("9.99")),
                new Fruit("banana", 10, new BigDecimal("19.99")),
                new Fruit("apple", 20, new BigDecimal("9.99"))
        );
        
        Map<String, Long> groupByName = fruits.stream().collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
        System.out.println("GROUPING BY THE NAME : "+groupByName);
        
        Map<String, Long> groupBySumOfTheQuantity = fruits.stream().
        		collect(Collectors.groupingBy(Fruit::getName, Collectors.summingLong(Fruit::getQty)));
        System.out.println("GROUPING BY NAME AND SUM OF THE QUANTITY : "+groupBySumOfTheQuantity);
        
        Map<BigDecimal, List<Fruit>> groupByPrice = fruits.stream().collect(Collectors.groupingBy(Fruit::getPrice));
        System.out.println("GROUPING BY PRICE : "+groupByPrice);
        
     // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> groupByPriceAndSetOfNames = fruits.stream().collect(
        		Collectors.groupingBy(Fruit::getPrice,Collectors.mapping(Fruit::getName, Collectors.toSet())));
        System.out.println("GROUP BY PRICE AND SET OF NAMES : "+groupByPriceAndSetOfNames);
        
        
	}

}
