import java.util.List;

public class TraditionalApproach {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5,6);
		printAll(numbers);
		printEven(numbers);
	}

	private static void printAll(List<Integer> numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}
	}
	
	private static void printEven(List<Integer> numbers) {
		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}
}
