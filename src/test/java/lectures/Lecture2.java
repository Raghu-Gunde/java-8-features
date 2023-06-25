package lectures;

import beans.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

    /*
       Open lecture2
       Complete method bellow: loop through people using IntStream  and print the each object.
        @Test
        public void rangeIteratingLists() throws Exception {
           List<Person> people = MockData.getPeople();
        }
        Think weather you need to use range or range close.
     */
    @Test
    public void range() throws Exception {
        System.out.println("using for loop");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("using IntStream exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("using IntStream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        //my solution to exercise
//        people.stream()
//                .limit(IntStream.range(0, people.size()).count())
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        //instructor's solution
        IntStream.range(0, people.size())
                .forEach(index->{
                    Person person = people.get(index);
                    System.out.println(person);
                });
    }

    @Test
    public void intStreamIterate() throws Exception {
        //use IntStream and print first 20 integer's
        IntStream.iterate(0, operand -> operand+1)
                .filter(number -> number%2 ==0)
                .limit(20)
                .forEach(System.out::println);
    }
}
