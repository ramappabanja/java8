import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ConvertListToMapExample {

	public static void main(String[] args) {
		List<Hosting> hostList = Arrays.asList(
				new Hosting(1, "liquidweb.com", 80000),
				new Hosting(2, "linode.com", 90000),
				new Hosting(3, "digitalocean.com", 120000),
				new Hosting(4, "aws.amazon.com", 200000),
				new Hosting(5, "mkyong.com", 1));
		// key id & values websites
		Map<Integer, Long> hostMap = hostList.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getWebsites, (oldValue, newValue)-> newValue));
		System.out.println("MAP OF key id & values websites : "+hostMap);
		
		// key name & values in websites
		Map<String, Long> hostMap2 = hostList.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> newValue));
		System.out.println("MAP OF key name & values websites : "+hostMap2);
		
		//sort map of key name & value websites
		Map<String, Long> sortedMap = hostList.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed()).collect(
				Collectors.toMap(Hosting::getName, Hosting::getWebsites,(oldValue, newValue)-> newValue, LinkedHashMap::new));
		System.out.println("SORTED MAP : "+sortedMap);
		
		
	}

}

class Hosting{
	private int Id;
    private String name;
    private long websites;
    
	public Hosting(int id, String name, long websites) {
		super();
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

	@Override
	public String toString() {
		return "Hosting [Id=" + Id + ", name=" + name + ", websites="
				+ websites + "]";
	}
}
