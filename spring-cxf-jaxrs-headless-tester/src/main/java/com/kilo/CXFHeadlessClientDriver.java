
package com.kilo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CXFHeadlessClientDriver {

    private static Logger LOG = Logger.getLogger(CXFHeadlessClientDriver.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "classpath:com/kilo/cxf/client-logging.xml",
                "classpath:com/kilo/cxf/clientApplicationContext.xml");
        classPathXmlApplicationContext.registerShutdownHook();
        LOG.info("Inited");

        SpecialService specialServiceImpl = classPathXmlApplicationContext
                .getBean("specialServiceClient", SpecialService.class);
        Integer someInt = specialServiceImpl.getSomeInt();
        LOG.info(someInt);

        String someText = specialServiceImpl.getSomeText();
        LOG.info(someText);

        List<String> someStrings = specialServiceImpl.getSomeStrings();
        LOG.info(someStrings);

        String data = "foo";
        List<String> someStringsWithInput = specialServiceImpl
                .getSomeStringsWithInput(data);
        LOG.info(someStringsWithInput);

        List<String> ids = Arrays.asList("foo", "baz");
        List<String> someStringsWithStringInputs = specialServiceImpl
                .getSomeStringsWithStringInputs(ids);
        LOG.info(someStringsWithStringInputs);

        List<Integer> intIds = Arrays.asList(1, 2);
        List<Integer> someStringsWithIntInputs = specialServiceImpl
                .getSomeStringsWithIntInputs(intIds);
        LOG.info(someStringsWithIntInputs);

        List<SpecialObject> someComplexObjectsWithIntInputs = specialServiceImpl
                .getSomeComplexObjectsWithIntInputs(intIds);
        LOG.info(someComplexObjectsWithIntInputs);

        String name = "foo";
        Integer value = 777;
        List<SpecialObject> someComplexObjectsWithMultipleInputs = specialServiceImpl
                .getSomeComplexObjectsWithMultipleInputs(name, value);
        LOG.info(someComplexObjectsWithMultipleInputs);

        Date date = new Date();
        List<SpecialObject> someComplexObjectsWithDateInput = specialServiceImpl
                .getSomeComplexObjectsWithDateInput(intIds, date);
        LOG.info(someComplexObjectsWithDateInput);

        SpecialObject input = new SpecialObject();
        List<SpecialObject> someComplexObjectsWithComplexInput = specialServiceImpl
                .getSomeComplexObjectsWithComplexInput(intIds, date, input);
        LOG.info(someComplexObjectsWithComplexInput);

        System.exit(1);
    }
}
