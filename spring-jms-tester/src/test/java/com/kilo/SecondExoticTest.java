/*
 * SecondExoticTest.java
 * 
 * $HeadURL: $
 * $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */

/*
 * Copyright (c) 2012 D. E. Shaw & Co., L.P. All rights reserved.
 *  
 * This software is the confidential and proprietary information
 * of D. E. Shaw & Co., L.P. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with D. E. Shaw & Co., L.P.
 */

package com.kilo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@formatter:off
/**
 * An exotic test class
 * 
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
@RunWith(Parameterized.class)
@Ignore
public class SecondExoticTest {

    private static Logger LOG = Logger.getLogger(SecondExoticTest.class);

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
