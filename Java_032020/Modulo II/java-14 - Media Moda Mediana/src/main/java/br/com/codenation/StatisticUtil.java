package br.com.codenation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (elements == null)? 0 :
				(int) Arrays.stream(elements).
						average().
						orElse(0.0);
	}

	public static int mode(int[] elements) {
		return (elements == null) ? 0 :
				Arrays.stream(elements).
						boxed().
						collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
						entrySet().stream().
						max(Comparator.comparing(Map.Entry::getValue)).
						get().
						getKey();
	}

	public static int median(int[] elements) {
		return (elements == null)? 0 :
				(int) Arrays.stream(elements).
						sorted().
						skip((elements.length - 1) / 2).
						limit(2 - elements.length % 2).
						average().
						orElse(0.0);
	}
}