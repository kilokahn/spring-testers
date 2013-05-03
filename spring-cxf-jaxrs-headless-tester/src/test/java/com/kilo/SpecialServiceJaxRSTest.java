
package com.kilo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:com/kilo/cxf/clientApplicationContext.xml",
        "classpath:com/kilo/cxf/client-logging.xml" })
public class SpecialServiceJaxRSTest {

    private static Logger LOG = Logger.getLogger(SpecialServiceJaxRSTest.class);

    @Resource(name = "specialServiceClient")
    private SpecialService specialService;

    @Test
    public void testGetSomeInt() {
        Integer someInt = specialService.getSomeInt();
        LOG.info(someInt);
    }

    @Test
    public void testGetSomeText() {
        String someText = specialService.getSomeText();
        LOG.info(someText);
    }

    @Test
    public void testGetSomeStrings() {
        List<String> someStrings = specialService.getSomeStrings();
        LOG.info(someStrings);
    }

    @Test
    public void testGetSomeStringsWithInput() {
        String data = "foo";
        List<String> someStringsWithInput = specialService
                .getSomeStringsWithInput(data);
        LOG.info(someStringsWithInput);
    }

    @Test
    public void testGetSomeStringsWithDateInput() {
        Date date = new Date();
        List<String> someStringsWithInput = specialService
                .getSomeStringsWithDateInput(date);
        LOG.info(someStringsWithInput);
    }

    @Test
    public void testGetSomeStringsWithStringInputs() {
        List<String> ids = Arrays.asList("foo", "baz");
        List<String> someStringsWithStringInputs = specialService
                .getSomeStringsWithStringInputs(ids);
        LOG.info(someStringsWithStringInputs);
    }

    @Test
    public void testGetSomeStringsWithIntInputs() {
        List<Integer> intIds = Arrays.asList(1, 2);
        List<Integer> someStringsWithIntInputs = specialService
                .getSomeIntsWithIntInputs(intIds);
        LOG.info(someStringsWithIntInputs);
    }

    @Test
    public void testGetSomeComplexObjectsWithIntInputs() {
        List<Integer> intIds = Arrays.asList(1, 2);
        List<SpecialObject> someComplexObjectsWithIntInputs = specialService
                .getSomeComplexObjectsWithIntInputs(intIds);
        LOG.info(someComplexObjectsWithIntInputs);
    }

    @Test
    public void testGetSomeComplexObjectsWithMultipleInputs() {
        String name = "foo";
        Integer value = 777;
        List<SpecialObject> someComplexObjectsWithMultipleInputs = specialService
                .getSomeComplexObjectsWithMultipleInputs(name, value);
        LOG.info(someComplexObjectsWithMultipleInputs);
    }

    @Test
    public void testGetSomeComplexObjectsWithDateInput() {
        List<Integer> intIds = Arrays.asList(1, 2);
        Date date = new Date();
        List<SpecialObject> someComplexObjectsWithDateInput = specialService
                .getSomeComplexObjectsWithDateInput(intIds, date);
        LOG.info(someComplexObjectsWithDateInput);
    }

    @Test
    public void testGetSomeComplexObjectsWithComplexInput() {
        List<Integer> intIds = Arrays.asList(1, 2);
        Date date = new Date();
        String name = "bond";
        Integer id = 7;
        SpecialObject input = new SpecialObject(name, id, date);
        List<SpecialObject> someComplexObjectsWithComplexInput = specialService
                .getSomeComplexObjectsWithComplexInput(intIds, date, input);
        LOG.info(someComplexObjectsWithComplexInput);
    }
}
