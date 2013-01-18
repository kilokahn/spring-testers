/*
 * ThirdExoticTest.java
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

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
@RunWith(Parameterized.class)
@ContextConfiguration(locations = { "/com/kilo/spring/logging.xml",
        "/com/kilo/spring/applicationContext.xml" })
public class ThirdExoticTest {

    private static Logger LOG = Logger.getLogger(ThirdExoticTest.class);

    @Autowired
    private PlatformTransactionManager transactionManager;

    public ThirdExoticTest(String testString) {
        this.testString = testString;
    }

    private TestContextManager testContextManager;

    private String testString;

    @Resource(name = "service1")
    private Service1 service1;

    @Before
    public void setUpContext() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    @Test
    public void testIfStringEmpty() {
        new TransactionTemplate(transactionManager)
                .execute(new TransactionCallback<Object>() {
                    public Object doInTransaction(TransactionStatus status) {
                        status.setRollbackOnly();
                        LOG.info("Running exotic 3rd test");
                        service1.foo(testString);
                        return null;
                    }
                });

    }

    @Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] { { "abc" }, { "xyz" }, });
    }
}
