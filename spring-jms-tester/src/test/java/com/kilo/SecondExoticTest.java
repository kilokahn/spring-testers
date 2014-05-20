package com.kilo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * An exotic test class
 */
@RunWith(Parameterized.class)
@Ignore
public class SecondExoticTest {

    private static Logger LOG = LoggerFactory.getLogger(SecondExoticTest.class);

    private static ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @BeforeClass
    public static void loadSpringContext() {
        System.out.println("Preparing exotic test");
        LOG.info("Preparing exotic test");
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "/com/kilo/spring/logging.xml",
                "/com/kilo/spring/applicationContext.xml");
    }

    @AfterClass
    public static void destroySpringContext() {
        LOG.info("Tearing down exotic test");
        classPathXmlApplicationContext.destroy();
    }

    @Test
    public void test() {
        LOG.info("Running exotic test");
    }

    @Parameters
    public static Collection<Object[]> getData() {
        List<Object[]> collection = new ArrayList<>();
        return collection;
    }

}
