
package com.kilo;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:com/kilo/embedded/jetty/clientApplicationContext.xml",
        "classpath:com/kilo/embedded/jetty/client-logging.xml" })
public class SpecialServiceJaxRSTest {

    private static Logger LOG = Logger.getLogger(SpecialServiceJaxRSTest.class);

    @Resource(name = "specialServiceClient")
    private SpecialService specialService;

    @Test
    public void testGetSomeText() {
        String someText = specialService.getSomeText();
        LOG.info(someText);
    }
}
