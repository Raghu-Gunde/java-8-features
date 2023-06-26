package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String namesSeparatedByComma ="";
    for(String name : names){
      namesSeparatedByComma +=name+", ";
    }
    System.out.println(namesSeparatedByComma.substring(0,namesSeparatedByComma.length()-2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String combinedNames = names.stream().collect(Collectors.joining(",", "-", "|"));
    System.out.println(combinedNames);
  }
}
