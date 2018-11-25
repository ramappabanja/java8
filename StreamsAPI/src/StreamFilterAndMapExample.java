import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class StreamFilterAndMapExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,66,88,100, 201, 20, 45);
		System.out.println("LIST OF INTEGERS : "+list);
		
		List<Integer> list1 = list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("LIST OF EVEN NUMBERS"+list1);
		
		list1 = list.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println("DOUBLING THE ELEMENTS : "+list1);
		
		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));

		System.out.println("GET A PERSON DETAILS BY NAME");
		Person person1 = persons.stream().filter(p->"THOMAS".equals(p.getFirstName())).findAny().orElse(null);
		System.out.println(person1);
		
		System.out.println("GET ONLY PERSON FIRST NAME BY NAME");
		String firstName = persons.stream().filter(p->"MATHEW".equals(p.getFirstName())).map(Person::getFirstName).findAny().orElse(null);
		System.out.println(firstName);
		
		System.out.println("GET ONLY PERSONS NAMES OF ALL");
//		persons.stream().map(Person::getFirstName).forEach(System.out::println); /* map(Person::getFirstName) === map(p->p.getFirstName())*/
		persons.stream().map(p->p.getFirstName()).forEach(System.out::println);
		
		System.out.println("PRINT THE ALL NAMES IN LOWERCASE");
		List<String> firstNames = persons.stream().map(Person::getFirstName).collect(Collectors.toList());
		firstNames.stream().map(String::toLowerCase).forEach(System.out::println);
		
		List<String> language = Arrays.asList("java", "python", "node", null, "ruby", null, "php");
		System.out.println("FILTER NULL VALUES FROM A LIST");
//		language.stream().filter(s->s!=null).collect(Collectors.toList()).forEach(System.out::println); /* s->s!=null === Objects::nonNull */
		language.stream().filter(Objects::nonNull).collect(Collectors.toList()).forEach(System.out::println);

	}

}
