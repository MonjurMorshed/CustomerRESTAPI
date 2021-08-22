package practice;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Monjur", "Morshed", "Mustafa", "Shamshad");

        String ss = names.stream()
                .filter(n -> n.contains("Mo"))
                .map(String::toUpperCase)
                .peek( n -> System.out.println(n))
                .collect(Collectors.joining(",")).toString();
        System.out.println(ss);
        System.out.println(oddNumbers(1,10));
    }
    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        if(arr.stream().anyMatch( number -> number == k)) return "YES";
        return "NO";
    }
    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> res = IntStream.range(l, r+1).filter(n -> n % 2 !=0).boxed().collect(Collectors.toList());
        return res;
    }

}
