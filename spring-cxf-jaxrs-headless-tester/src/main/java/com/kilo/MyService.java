
package com.kilo;

import java.util.Date;
import java.util.List;

public interface MyService {

    String getSomeText();

    Integer getSomeInt();

    List<String> getSomeStrings();

    List<String> getSomeStringsWithInput(String data);

    List<String> getSomeStringsWithStringInputs(List<String> ids);

    List<Integer> getSomeStringsWithIntInputs(List<Integer> ids);

    List<MyComplexObject> getSomeComplexObjectsWithIntInputs(List<Integer> ids);

    List<MyComplexObject> getSomeComplexObjectsWithMultipleInputs(String name,
            Integer value);

    List<MyComplexObject> getSomeComplexObjectsWithDateInput(
            List<Integer> ids, Date date);

    List<MyComplexObject> getSomeComplexObjectsWithComplexInput(
            List<Integer> ids, Date date, MyComplexObject input);
}
