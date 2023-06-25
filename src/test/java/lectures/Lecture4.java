package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class Lecture4 {
    /*
        If we want to collect to set than go with 2nd approach
        if we want only a list with no duplicates than go with 1st approach
     */
    @Test
    public void distinct() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        //distinctNumbers.forEach(System.out::println);
        System.out.println(distinctNumbers);
    }

    @Test
    public void distinctWithSet() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinctNumberWithSet = numbers.stream().collect(Collectors.toSet());
        System.out.println(distinctNumberWithSet);
    }
}
