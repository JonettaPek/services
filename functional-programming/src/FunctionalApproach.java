import java.util.List;

public class FunctionalApproach {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5,6);
		printAllMethodReference(numbers);
		printAllLambdaExpression(numbers);
		printEven(numbers);
		printOdd(numbers);
		printSquare(numbers);
		printCubeOfOddNumbers(numbers);
		// Exercises
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		printAllMethodReference(courses);
		printCoursesContainingSpring(courses);
		printCoursesAtLeast4Characters(courses);
		printLengthOfCourseName(courses);
	}

	private static void printAllMethodReference(List<? extends Object> objects) {
		System.out.println("Printing all objects via method reference");
		objects.stream()
			.forEach(System.out::println);
	}
	
	private static void printAllLambdaExpression(List<? extends Object> objects) {
		// Functional interface is a specification and lambda expression is the implementation of a functional interface
		System.out.println("Printing all objects via lambda expression");
		objects.stream()
			.forEach(number -> System.out.println(number));
	}
	
	private static void printEven(List<Integer> numbers) {
		System.out.println("Printing even numbers");
		numbers.stream()
			.filter(number -> number % 2 == 0)
			.forEach(System.out::println);
	}
	
	private static void printOdd(List<Integer> numbers) {
		System.out.println("Printing odd numbers");
		numbers.stream()
		.filter(number -> number % 2 != 0)
		.forEach(System.out::println);
	}
	
	private static void printSquare(List<Integer> numbers) {
		System.out.println("Printing the square of all numbers");
		numbers.stream()
			.map(number -> number*number)
			.forEach(System.out::println);
	}
	
	private static void printCubeOfOddNumbers(List<Integer> numbers) {
		System.out.println("Printing the cube of odd numbers");
		numbers.stream()
			.filter(number -> number % 2 != 0)
			.map(number -> number*number*number)
			.forEach(System.out::println);
	}
	
	private static void printCoursesContainingSpring(List<String> courses) {
		System.out.println("Printing all courses containing 'Spring'");
		courses.stream()
			.filter(course -> course.toLowerCase().contains("spring"))
			.forEach(System.out::println);
	}
	
	private static void printCoursesAtLeast4Characters(List<String> courses) {
		System.out.println("Printing all courses with at least 4 characters");
		courses.stream()
			.filter(course -> course.length() >= 4)
			.forEach(System.out::println);
	}
	
	private static void printLengthOfCourseName(List<String> courses) {
		System.out.println("Printing length of each course");
		courses.stream()
			.map(course -> String.format("The course %s has %s characters", course, course.length()))
			.forEach(System.out::println);
	}
}
