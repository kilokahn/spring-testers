
package com.kilo;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kilo.domain.SomeObject;
import com.kilo.service.SomeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:com/kilo/cxf/clientApplicationContext.xml",
        "classpath:com/kilo/cxf/client-logging.xml" })
public class SomeServiceJaxRSTest {

    private static Logger LOG = Logger.getLogger(SomeServiceJaxRSTest.class);

    @Resource(name = "someServiceClient")
    private SomeService someService;

    @Test
    public void testGetSomeComplexObjectsWithIntInputs() {
        List<Integer> intIds = Arrays.asList(1, 2);
        List<? extends SomeObject<String>> someComplexObjectsWithIntInputs = someService
                .getSomeComplexObjectsWithIntInputs(intIds);
        LOG.info(someComplexObjectsWithIntInputs);
    }
}
