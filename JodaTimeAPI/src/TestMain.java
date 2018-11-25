import java.time.*;


public class TestMain {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("DATE IS : "+date);
		
		LocalTime time = LocalTime.now();
		System.out.println("TIME IS : "+time);
		
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();
	}

}
