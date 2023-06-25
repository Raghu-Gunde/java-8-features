package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> personsAged18 = new ArrayList<>();
    // 1. Find people aged less or equal 18
    for(Person p : people){
      if(p.getAge()<=18)
        personsAged18.add(p);
    }
    System.out.println(personsAged18);
    // 2. Then change implementation to find first 10 people
    System.out.println("First 10 People :: "+personsAged18.subList(0,10));
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

  }
}
