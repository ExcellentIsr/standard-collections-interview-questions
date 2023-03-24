package telran.test;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandartCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void displayoccurrencesCount() {
		String[] strings = {"lmn", "abc", "abc", "lmn", "a", "lmn"};
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.printf("%s: %d \n", e.getKey(), e.getValue()));
	}

	@Test
	void displayDigitStatistics() {
		int countNumbers = 1_000_000, from = 1, to = Integer.MAX_VALUE - 1;
		
		new Random().ints(countNumbers, from, to).flatMap(n -> Integer.toString(n).chars()).boxed()
			.collect(Collectors.groupingBy(digit -> digit, Collectors.counting())).entrySet()
			.stream().sorted((e1, e2) -> Long.compare(e1.getKey(), e2.getKey()))
			.forEach(d -> System.out.printf("%d is %d\n", d.getKey() - 48, d.getValue()));
	}
}
