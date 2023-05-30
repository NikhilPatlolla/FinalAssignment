package com.nikhil.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {
	public static void main(String[] args) {
		List<Integer> dataset = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160,
				170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360, 370,
				380, 390, 400, 410, 420, 430, 440, 450, 460, 470, 480, 490, 500);

		System.out.println(dataset);

		// we get the stream object by using the stream() on the list object
		System.out.println("filtering only values that are divisible by 7");
		List<Integer> divisibleBy7 = dataset.stream().filter(e -> e % 7 == 0).collect(Collectors.toList());
		System.out.println(divisibleBy7);

		System.out.println("the count could also be gotten using the count method at the end");
		long count = dataset.stream().filter(e -> e % 7 == 0).count();
		System.out.println(count);

		System.out.println("divinding all the values in the list by 10");
		List<Integer> collect = dataset.stream().map(e -> e / 10).collect(Collectors.toList());
		System.out.println(collect);

		System.out.println(
				"we can also create new objects of class using the constuctor and including the integer as a constructor argument");
		List<Sample> collect2 = dataset.stream().map(Sample::new).collect(Collectors.toList());
		System.out.println(collect2);

		System.out.println(dataset);

		Integer sum = dataset.stream().reduce(0, Integer::sum);
		Integer max = dataset.stream().reduce(0, Integer::max);
		System.out.println("sum of the elements " + sum);
		System.out.println("max of the elements " + max);

		Integer mmax = dataset.stream().max(Integer::compareTo).orElse(0);
		System.out.println("the max value when there is no max method within the class " + mmax);

		long count2 = dataset.stream().filter(e -> e % 2 == 0).count();
		System.out.println(count2);

		List<Person> dataset2 = Arrays.asList(new Person("John", 25, "New York"), new Person("Emily", 30, "London"),
				new Person("Adam", 35, "San Francisco"), new Person("Sophia", 28, "Paris"),
				new Person("Michael", 40, "Los Angeles"));

		// Sorting by age
		List<Person> sortedByAge = dataset2.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge())
				.collect(Collectors.toList());
		System.out.println("People sorted by age: " + sortedByAge);

		// Filtering and mapping
		List<String> names = dataset2.stream().filter(p -> p.getAge() < 30).map(Person::getName)
				.collect(Collectors.toList());
		System.out.println("Names of people under 30: " + names);

		// Grouping by city
		Map<String, List<Person>> peopleByCity = dataset2.stream().collect(Collectors.groupingBy(Person::getCity));
		System.out.println("People grouped by city: " + peopleByCity);

		// Average age
		double averageAge = dataset2.stream().mapToInt(Person::getAge).average().orElse(0);
		System.out.println("Average age: " + averageAge);

	}
}
