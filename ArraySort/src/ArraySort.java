
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ArraySort {

	// private static final Object[] Set = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrayFirst[] = { 1, 1, 1, 3, 2, 4, 4, 3 };
		int secondArray[] = { 2, 5, 15, 12, 19, 17 };
		List<Integer> result = new ArrayList<>();
		findEqualsFirst(arrayFirst, secondArray, result);
		System.out.println(result);
		result.clear();
		findEqualsSecond(arrayFirst, secondArray, result);
		System.out.println(result);
		result.clear();
		findNotEquals(arrayFirst, secondArray, result);
		System.out.println(result);
		result.clear();
		result = sortArrayByNumberOfOccurrencesWithStream(arrayFirst);
		System.out.println(result);

	}

	private static void findEqualsSecond(int[] arrayFirst, int[] secondArray, Collection<Integer> result) {
		Arrays.sort(arrayFirst);
		Arrays.sort(secondArray);
		int firstIndex = 0;
		int secondIndex = 0;
		while (firstIndex < arrayFirst.length && secondIndex < secondArray.length) {
			if (arrayFirst[firstIndex] == secondArray[secondIndex]) {

				int val = arrayFirst[firstIndex];

				result.add(val);
				firstIndex++;
				secondIndex++;
				while (firstIndex < arrayFirst.length && val == arrayFirst[firstIndex]) {
					firstIndex++;
				}
				;

			} else if (arrayFirst[firstIndex] < secondArray[secondIndex]) {
				firstIndex++;

			} else {
				secondIndex++;
			}
		}
	}

	private static void findEqualsFirst(int[] arrayFirst, int[] secondArray, Collection<Integer> result) {
		outer: for (int i = 0; i < arrayFirst.length; i++) {
			for (int k = 0; k < i; k++) {
				if (arrayFirst[k] == arrayFirst[i]) {
					continue outer;
				}
			}
			for (int j = 0; j < secondArray.length; j++) {
				if (arrayFirst[i] == secondArray[j]) {
					result.add(arrayFirst[i]);
					break;
				}
			}
		}
	}

	private static void findNotEquals(int[] arrayFirst, int[] secondArray, Collection<Integer> result) {

		outer: for (int i = 0; i < arrayFirst.length; i++) {
			for (int k = i + 1; k < arrayFirst.length; k++) {
				if (arrayFirst[k] == arrayFirst[i]) {
					continue outer;
				}
			}
			for (int j = 0; j < secondArray.length; j++) {
				if (arrayFirst[i] == secondArray[j]) {
					continue outer;
				}
			}
			result.add(arrayFirst[i]);

		}
		outer2: for (int i = 0; i < secondArray.length; i++) {
			for (int k = i + 1; k < secondArray.length; k++) {
				if (secondArray[k] == secondArray[i]) {
					continue outer2;
				}
			}
			for (int j = 0; j < arrayFirst.length; j++) {
				if (secondArray[i] == arrayFirst[j]) {
					continue outer2;
				}
			}

			result.add(secondArray[i]);

		}

	}

	public static List<Integer> sortArrayByNumberOfOccurrences(int[] array) {

		Map<Integer, Integer> occurrenceElementNumber = new HashMap<>();
		Map<Integer, Set<Integer>> elementSetsByOccurrence = new TreeMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!occurrenceElementNumber.containsKey(array[i])) {
				occurrenceElementNumber.put(array[i], 0);
			}
			occurrenceElementNumber.put(array[i], occurrenceElementNumber.get(array[i]) + 1);

		}
		for (int k : occurrenceElementNumber.keySet()) {
			int occurrenceNumber = occurrenceElementNumber.get(k);
			if (!elementSetsByOccurrence.containsKey(occurrenceNumber)) {
				elementSetsByOccurrence.put(occurrenceNumber, new TreeSet<>());
			}
			Set<Integer> elementsWithSameOccurrenceNumber = elementSetsByOccurrence.get(occurrenceNumber);
			elementsWithSameOccurrenceNumber.add(k);
			elementSetsByOccurrence.put(occurrenceNumber, elementsWithSameOccurrenceNumber);
		}

		List<Integer> sortedElements = new ArrayList<>();

		Iterator<Entry<Integer, Set<Integer>>> entries = elementSetsByOccurrence.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, Set<Integer>> entry = entries.next();
			for (Integer k : entry.getValue()) {
				for (int i = 0; i < entry.getKey(); i++) {
					sortedElements.add(k);
				}
			}

		}

		return sortedElements;
	}

	public static List<Integer> sortArrayByNumberOfOccurrencesWithStream(int[] array) {

		Stream<Map.Entry<Integer, Long>> map = Arrays.stream(array).boxed()
				.collect(groupingBy(e -> e, Collectors.counting())).entrySet()
				.stream().sorted((element1, element2) -> {
					return Long.compare(element1.getValue(), element2.getValue());
				});

		List<Integer> result = new ArrayList<>();
		map.forEach(entry -> {
			for (int i = 0; i < entry.getValue(); i++) {
				result.add(entry.getKey());

			}
		});

		return result;
	}

}
