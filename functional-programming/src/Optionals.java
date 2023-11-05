import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Optionals {

	public static void main(String[] args) {
		List<String> fruits = List.of("apple", "banana", "mango");
		Predicate<? super String> startsWithB = fruit -> fruit.toLowerCase().startsWith("b");
		Optional<String> optionalFruit = fruits.stream()
										.filter(startsWithB)
										.findFirst();
		System.out.println(optionalFruit); // Optional[banana] or Optional.empty
		System.out.println(optionalFruit.isPresent()); 
		System.out.println(optionalFruit.isEmpty());
		System.out.println(optionalFruit.get()); // banana or NullPointerException
	}

}
