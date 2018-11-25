import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class ReuseAStreamExample {

	public static void main(String[] args) {
		String[] array = {"a","b","c","d","e"};
		Stream<String> stream = Arrays.stream(array);
		
		//loop a stream
		stream.forEach(System.out::println);
		
		//reuse a stream to filter again! throws IllegalStateException
//		long count = stream.filter(x->"c".equals(x)).count();
		
		Supplier<Stream<String>> streamSupplier = ()->Stream.of(array);
		
		//get new stream
		System.out.println("LOOP THE STREAM USING SUPPLIER");
		streamSupplier.get().forEach(System.out::println);
		
		//get another new stream to filter and get the count
		long count = streamSupplier.get().filter(x->"c".equals(x)).count();
		System.out.println("COUNT IS : "+count);
	}

}
