
package com.kilo;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(Parameterized.class)
@ContextConfiguration(locations = { "/com/kilo/spring/logging.xml",
        "/com/kilo/spring/applicationContext.xml" })
public class ThirdExoticTest {

    private static Logger LOG = LoggerFactory.getLogger(ThirdExoticTest.class);

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
