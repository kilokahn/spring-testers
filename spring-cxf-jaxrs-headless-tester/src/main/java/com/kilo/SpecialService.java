
package com.kilo;

import java.util.Date;
import java.util.List;

public interface SpecialService {

    String getSomeText();

    Integer getSomeInt();

    List<String> getSomeStrings();

    List<String> getSomeStringsWithInput(String data);

    List<String> getSomeStringsWithDateInput(Date data);

    List<String> getSomeStringsWithStringInputs(List<String> ids);

    List<Integer> getSomeStringsWithIntInputs(List<Integer> ids);

    List<SpecialObject> getSomeComplexObjectsWithIntInputs(List<Integer> ids);

    List<SpecialObject> getSomeComplexObjectsWithMultipleInputs(String name,
            Integer value);

    List<SpecialObject> getSomeComplexObjectsWithDateInput(
            List<Integer> ids, Date date);

    List<SpecialObject> getSomeComplexObjectsWithComplexInput(
            List<Integer> ids, Date date, SpecialObject input);
}
