package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
  /*
   count is used to find the number of objects based on the filter.
   i.e., works exactly as count of SQL
   Eg: find the number of females from people list
   */
    ImmutableList<Person> people = MockData.getPeople();
    long femaleCount = people.stream()
            .filter(p -> p.getGender().equals("Female"))
            .count();
    System.out.println(femaleCount);
  }

  @Test
  public void min() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    double min = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .min()
            .getAsDouble();
    System.out.println(min);

  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars().stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .max()
            .getAsDouble();
    System.out.println(max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double avg = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(avg);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
            .mapToDouble(Car::getPrice)
            .sum();
    BigDecimal decimalSum = BigDecimal.valueOf(sum);
    System.out.println(decimalSum);


  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
            .mapToDouble(Car::getPrice)
            .summaryStatistics();
    System.out.println("Statistics :: "+doubleSummaryStatistics);
    System.out.println("Min :: "+doubleSummaryStatistics.getMin());
    System.out.println("Max :: "+doubleSummaryStatistics.getMax());
    System.out.println("Average :: "+doubleSummaryStatistics.getAverage());
    System.out.println("Count :: "+doubleSummaryStatistics.getCount());
    System.out.println("Sum :: "+BigDecimal.valueOf(doubleSummaryStatistics.getSum()));

  }

}