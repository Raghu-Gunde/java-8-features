package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();
        Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
        cars.stream()
                .filter(carPredicate)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                // .map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                // we have a function called map in persondto to map
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        //personDTOS.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(personDTOS.size());
    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        ImmutableList<Car> cars = MockData.getCars();
        double avgPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .getAsDouble();
        double avgPrice1 = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(avgPrice);
    }

    @Test
    public void test() throws Exception {

    }
}



