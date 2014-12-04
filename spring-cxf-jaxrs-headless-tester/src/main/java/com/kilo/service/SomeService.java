
package com.kilo.service;

import java.util.List;

import com.kilo.domain.SomeObject;

public interface SomeService {

    List<? extends SomeObject<String>> getSomeComplexObjectsWithIntInputs(List<Integer> ids);

}
